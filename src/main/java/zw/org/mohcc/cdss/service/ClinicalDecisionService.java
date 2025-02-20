package zw.org.mohcc.cdss.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.org.mohcc.cdss.model.dto.*;
import zw.org.mohcc.cdss.repository.*;

import java.time.LocalDate;
import java.util.*;

@Service
public class ClinicalDecisionService {

    private static final Logger logger = LoggerFactory.getLogger(ClinicalDecisionService.class);
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
            Object[] firstRow = results.get(0);
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
            Object[] firstRow = dateRows.get(0);
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

    public List<ClinicalDecision> evaluatePatientRules(String personId) {
        List<Map<String, Object>> patientData = processArtData(personId);

        if (patientData.isEmpty()) {
            logger.warn("No patient data found for personId: {}", personId);
            return Collections.emptyList();
        }

        PatientArtData patient = convertToPatientArtData(patientData.get(0));

        // Get the named session from kmodule.xml
        try (KieSession kieSession = kieContainer.newKieSession("ksession-rules")) {

            try {
                List<ClinicalDecision> decisions = new ArrayList<>();
                kieSession.setGlobal("decisions", decisions);
                kieSession.insert(patient);
                kieSession.fireAllRules();
                return decisions;
            } finally {
                kieSession.dispose();
            }
        }
    }

    private PatientArtData convertToPatientArtData(Map<String, Object> data) {
        PatientArtData patient = new PatientArtData();

        // Set basic patient information
        patient.setPersonId((String) data.get("personId"));
        patient.setBirthDate(convertToLocalDate((Date) data.get("birthDate")));
        patient.setDateOfHivTest(convertToLocalDate((Date) data.get("dateOfHivTest")));
        patient.setDateEnrolled(convertToLocalDate((Date) data.get("dateEnrolled")));
        patient.setSex((String) data.get("sex"));
        patient.setArtNumber((String) data.get("artNumber"));
        patient.setSiteId((String) data.get("siteId"));

        // Convert statuses
        List<Map<String, Object>> statusMaps = (List<Map<String, Object>>) data.get("statuses");
        List<ArtStatus> statuses = new ArrayList<>();

        for (Map<String, Object> statusMap : statusMaps) {
            ArtStatus status = new ArtStatus();
            status.setDate(convertToLocalDate((Date) statusMap.get("date")));
            status.setReason((String) statusMap.get("reason"));
            status.setArtStatusId((String) statusMap.get("artStatusId"));
            status.setReasonForRegimenSubstitution((String) statusMap.get("reasonForRegimenSubstitution"));
            status.setRegimenFrom((String) statusMap.get("regimenFrom"));
            status.setTreatmentFailureReason((String) statusMap.get("treatmentFailureReason"));
            status.setAdverseEventStatus((String) statusMap.get("adverseEventStatus"));
            status.setRegimenLineFromName((String) statusMap.get("regimenLineFromName"));
            status.setState((String) statusMap.get("state"));
            status.setRegimenLineName((String) statusMap.get("regimenLineName"));
            status.setRegimen((String) statusMap.get("regimen"));

            // Convert WHO stages
            List<Map<String, Object>> whoStageMaps = (List<Map<String, Object>>) statusMap.get("whoStages");
            List<WhoStage> whoStages = new ArrayList<>();

            for (Map<String, Object> whoStageMap : whoStageMaps) {
                WhoStage whoStage = new WhoStage();
                whoStage.setDate(convertToLocalDate((Date) whoStageMap.get("date")));
                whoStage.setArtStageId((String) whoStageMap.get("artStageId"));
                whoStage.setWhoStage((String) whoStageMap.get("whoStage"));
                whoStage.setFollowUpStatus((String) whoStageMap.get("followUpStatus"));
                whoStages.add(whoStage);
            }
            status.setWhoStages(whoStages);

            // Convert investigations
            List<Map<String, Object>> investigationMaps = (List<Map<String, Object>>) statusMap.get("investigations");
            List<Investigation> investigations = new ArrayList<>();

            for (Map<String, Object> investigationMap : investigationMaps) {
                Investigation investigation = new Investigation();
                investigation.setType((String) investigationMap.get("investigationType"));
                investigation.setResult((String) investigationMap.get("result"));
                investigation.setDate(convertToLocalDate((Date) investigationMap.get("date")));
                investigations.add(investigation);
            }
            status.setInvestigations(investigations);

            statuses.add(status);
        }

        patient.setStatuses(statuses);
        return patient;
    }

    // Helper method to convert sql date to LocalDate
    private LocalDate convertToLocalDate(Date date) {
        if (date == null) {
            return null;
        }

        // Handle java.sql.Date specifically
        if (date instanceof java.sql.Date) {
            return ((java.sql.Date) date).toLocalDate();
        }

        // Handle java.util.Date
        return new java.sql.Date(date.getTime()).toLocalDate();
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

}
