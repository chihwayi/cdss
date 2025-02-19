package zw.org.mohcc.cdss.service;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.org.mohcc.cdss.model.dto.ClinicalAlert;
import zw.org.mohcc.cdss.model.dto.PatientAssessment;
import zw.org.mohcc.cdss.model.dto.TreatmentAlert;
import zw.org.mohcc.cdss.model.enums.AlertSeverity;
import zw.org.mohcc.cdss.repository.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@Slf4j
public class ClinicalDecisionService {
    private final KieContainer kieContainer;
    private final ArtRegisterRepository artRegisterRepository;

    @Autowired
    public ClinicalDecisionService(
            KieContainer kieContainer,
            ArtRegisterRepository artRegisterRepository
    ) {
        this.kieContainer = kieContainer;
        this.artRegisterRepository = artRegisterRepository;
    }

    public List<Map<String, Object>> processArtData(String personId) {
        List<Object[]> results = artRegisterRepository.findArtRegisterByPersonId(personId);
        Map<String, Object> root = new HashMap<>();

        // Basic patient details (assumed unchanged)
        if (!results.isEmpty()) {
            Object[] firstRow = results.getFirst();
            root.put("artId", firstRow[0]);
            root.put("siteId", firstRow[1]);
            root.put("artNumber", firstRow[2]);
            root.put("birthDate", firstRow[3]);
            root.put("dateEnrolled", firstRow[4]);
            root.put("dateOfHivTest", firstRow[5]);
            root.put("personId", firstRow[6]);
            root.put("sex", firstRow[7]);
        }

        // First pass: Group all data by status date
        Map<Date, List<Object[]>> dateGroupedResults = new LinkedHashMap<>();
        for (Object[] row : results) {
            Date statusDate = (Date) row[10]; // acr.date
            dateGroupedResults.computeIfAbsent(statusDate, k -> new ArrayList<>()).add(row);
        }

        // Second pass: Process each date group
        List<Map<String, Object>> statusEntries = new ArrayList<>();
        for (Map.Entry<Date, List<Object[]>> entry : dateGroupedResults.entrySet()) {
            Date statusDate = entry.getKey();
            List<Object[]> dateRows = entry.getValue();

            // Create status entry from first row of the group
            Object[] firstRow = dateRows.getFirst();
            Map<String, Object> statusEntry = new HashMap<>();
            statusEntry.put("artStatusId", firstRow[8]);
            statusEntry.put("adverseEventStatus", firstRow[9]);
            statusEntry.put("date", statusDate);
            statusEntry.put("reason", firstRow[11]);
            statusEntry.put("reasonForRegimenSubstitution", firstRow[12]);
            statusEntry.put("regimen", firstRow[13]);
            statusEntry.put("regimenFrom", firstRow[14]);
            statusEntry.put("regimenLineFromName", firstRow[15]);
            statusEntry.put("regimenLineName", firstRow[16]);
            statusEntry.put("state", firstRow[17]);
            statusEntry.put("treatmentFailureReason", firstRow[18]);

            // Use Set to track unique investigation IDs
            Set<String> processedInvestigationIds = new HashSet<>();
            List<Map<String, Object>> investigations = new ArrayList<>();

            // Use Set to track unique whoStatus IDs
            Set<String> processedWhoStagesIds = new HashSet<>();
            List<Map<String, Object>> whoStages = new ArrayList<>();

            // Process all rows for this date
            for (Object[] row : dateRows) {
                // Investigation Register
                Date irDate = (Date) row[27];
                String irId = row[26] != null ? row[26].toString() : null;

                if (row[27] != null && isSameDay(irDate, statusDate) &&
                        irId != null && !processedInvestigationIds.contains(irId)) {
                    Map<String, Object> investigation = new HashMap<>();
                    investigation.put("laboratoryInvestigationId", irId);
                    investigation.put("date", row[27]);
                    investigation.put("dateResultIssued", row[28]);
                    investigation.put("investigationType", row[29]);
                    investigation.put("note", row[30]);
                    investigation.put("result", row[31]);
                    investigation.put("resultDate", row[32]);
                    investigation.put("resultIssued", row[33]);
                    investigations.add(investigation);
                    processedInvestigationIds.add(irId);
                }
            }
            for (Object[] row : dateRows) {
                // WHO Status Register
                Date whoDate = (Date) row[35];
                String whoId = row[34] != null ? row[34].toString() : null;

                if (row[35] != null && isSameDay(whoDate, statusDate) &&
                        whoId != null && !processedWhoStagesIds.contains(whoId)){

                    Map<String, Object> whoStage = new HashMap<>();
                    whoStage.put("artStageId", row[34]);
                    whoStage.put("date", row[35]);
                    whoStage.put("whoStage", row[36]);
                    whoStage.put("followUpStatus", row[37]);
                    whoStages.add(whoStage);
                    processedWhoStagesIds.add(whoId);
                }
            }

            // Add investigations and who stage to status entry
            statusEntry.put("investigations", investigations);
            statusEntry.put("whoStages", whoStages);
            statusEntries.add(statusEntry);
        }

        // Add status entries to root
        root.put("statuses", statusEntries);
        return Collections.singletonList(root);
    }

    // Helper method to compare dates ignoring time component
    private boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public PatientAssessment evaluatePatient(String personId) {
        // Get the patient data using existing method
        List<Map<String, Object>> patientData = processArtData(personId);
        if (patientData.isEmpty()) {
            throw new RuntimeException("Patient data not found for ID: " + personId);
        }

        // Create KieSession for rules evaluation
        try (KieSession kieSession = kieContainer.newKieSession()) {

            try {
                // Insert patient data into session
                Map<String, Object> patient = patientData.getFirst();
                kieSession.insert(patient);

                // Fire all rules
                kieSession.fireAllRules();

                // Collect all alerts from the session
                List<Map<String, Object>> alerts = new ArrayList<>();
                for (Object obj : kieSession.getObjects()) {
                    if (obj instanceof Map && ((Map<?, ?>) obj).containsKey("type")) {
                        alerts.add((Map<String, Object>) obj);
                    }
                }

                // Create patient assessment based on the data and alerts
                return createPatientAssessment(patient, alerts);

            } finally {
                kieSession.dispose();
            }
        }
    }

    private PatientAssessment createPatientAssessment(Map<String, Object> patient, List<Map<String, Object>> alerts) {
        PatientAssessment assessment = new PatientAssessment();
        assessment.setPersonId((String) patient.get("personId"));

        // Process statuses if available
        List<Map<String, Object>> statuses = (List<Map<String, Object>>) patient.get("statuses");
        if (statuses != null && !statuses.isEmpty()) {
            // Sort statuses by date in descending order to get the most recent first
            statuses.sort((s1, s2) -> ((Date) s2.get("date")).compareTo((Date) s1.get("date")));

            // Get the most recent status
            Map<String, Object> latestStatus = statuses.getFirst();

            // Set current status information
            assessment.setState((String) latestStatus.get("state"));
            assessment.setReason((String) latestStatus.get("reason"));
            assessment.setCurrentArtStatus((String) latestStatus.get("state"));

            // Determine if patient is currently on ART
            assessment.setOnArt("ACTIVE".equals(latestStatus.get("state")) ||
                    "CONTINUE".equals(latestStatus.get("state")));

            // Calculate months on ART
            Date startDate = findInitialStartDate(statuses);
            if (startDate != null) {
                LocalDate startLocalDate = startDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                assessment.setMonthsOnArt((int) ChronoUnit.MONTHS.between(startLocalDate, LocalDate.now()));
            }

            // Process the most recent investigations
            processInvestigations(latestStatus, assessment);

            // Process historical viral loads for trending
            List<Double> historicalViralLoads = new ArrayList<>();
            for (Map<String, Object> status : statuses) {
                List<Map<String, Object>> investigations = (List<Map<String, Object>>) status.get("investigations");
                if (investigations != null) {
                    for (Map<String, Object> investigation : investigations) {
                        if ("VIRAL_LOAD".equals(investigation.get("investigationType"))) {
                            String result = (String) investigation.get("result");
                            if (result != null) {
                                historicalViralLoads.add(Double.valueOf(result));
                            }
                        }
                    }
                }
            }

            // Add historical viral loads to assessment if needed
            assessment.setHistoricalViralLoads(historicalViralLoads);
        }

        // Process alerts
        processClinicalAndTreatmentAlerts(assessment, alerts);

        return assessment;
    }

    private Date findInitialStartDate(List<Map<String, Object>> statuses) {
        // Find the earliest START_ARV status
        return statuses.stream()
                .filter(status -> "START_ARV".equals(status.get("state")))
                .map(status -> (Date) status.get("date"))
                .min(Date::compareTo)
                .orElse(null);
    }

    private void processInvestigations(Map<String, Object> status, PatientAssessment assessment) {
        List<Map<String, Object>> investigations = (List<Map<String, Object>>) status.get("investigations");
        if (investigations != null) {
            for (Map<String, Object> investigation : investigations) {
                String type = (String) investigation.get("investigationType");
                String result = (String) investigation.get("result");

                if (result != null) {
                    if ("CD4_COUNT".equals(type)) {
                        assessment.setCd4Count(Double.valueOf(result));
                    } else if ("VIRAL_LOAD".equals(type)) {
                        assessment.setLastViralLoad(Double.valueOf(result));
                        // Calculate months since last viral load
                        Date vlDate = (Date) investigation.get("date");
                        if (vlDate != null) {
                            LocalDate testDate = vlDate.toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate();
                            assessment.setMonthsSinceLastViralLoad(
                                    (int) ChronoUnit.MONTHS.between(testDate, LocalDate.now())
                            );
                        }
                    }
                }
            }
        }
    }

    private void processClinicalAndTreatmentAlerts(PatientAssessment assessment, List<Map<String, Object>> alerts) {
        List<ClinicalAlert> clinicalAlerts = new ArrayList<>();
        List<TreatmentAlert> treatmentAlerts = new ArrayList<>();

        for (Map<String, Object> alert : alerts) {
            String type = (String) alert.get("type");
            String message = (String) alert.get("message");
            String severity = (String) alert.get("severity");

            if (type.endsWith("_ALERT")) {
                ClinicalAlert clinicalAlert = new ClinicalAlert();
                clinicalAlert.setCode(type);
                clinicalAlert.setMessage(message);
                clinicalAlert.setAction("Please review and take appropriate action.");
                clinicalAlerts.add(clinicalAlert);
            } else {
                TreatmentAlert treatmentAlert = new TreatmentAlert();
                treatmentAlert.setAlertCode(type);
                treatmentAlert.setMessage(message);
                treatmentAlert.setSeverity(AlertSeverity.valueOf(severity));
                treatmentAlert.setPatientId(assessment.getPersonId());
                treatmentAlerts.add(treatmentAlert);
            }
        }

        assessment.setClinicalAlerts(clinicalAlerts);
        assessment.setTreatmentAlerts(treatmentAlerts);
    }

}
