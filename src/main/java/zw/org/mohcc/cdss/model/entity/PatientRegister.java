package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patient_register")
public class PatientRegister {
    @Id
    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "site_id")
    private String siteId;

    @Column(name = "danger_signs")
    private String dangerSigns;

    @Column(name = "admission_time")
    private Date admissionTime;

    @Column(name = "blood_pressure")
    private String bloodPressure;

    @Lob
    @Column(name = "complaints")
    private String complaints;

    @Column(name = "date")
    private Date date;

    @Lob
    @Column(name = "diagnoses")
    private String diagnoses;

    @Column(name = "discharged")
    private Boolean discharged;

    @Lob
    @Column(name = "examinations")
    private String examinations;

    @Column(name = "fetal_heart_rate")
    private String fetalHeartRate;

    @Column(name = "height")
    private Double height;

    @Lob
    @Column(name = "investigations")
    private String investigations;

    @Lob
    @Column(name = "medicines")
    private String medicines;

    @Column(name = "muac")
    private Double muac;

    @Column(name = "note")
    private String note;

    @Column(name = "opd")
    private Boolean opd;

    @Column(name = "patient_type")
    private String patientType;

    @Column(name = "pulse")
    private Double pulse;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "respiratory_rate")
    private Double respiratoryRate;

    @Column(name = "tb_screened")
    private String tbScreened;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "visit_outcome")
    private String visitOutcome;

    @Column(name = "weight")
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonDemographic personDemographic;

    public PatientRegister() {
    }

    public PatientRegister(String patientId, String siteId, String dangerSigns, Date admissionTime, String bloodPressure, String complaints, Date date, String diagnoses, Boolean discharged, String examinations, String fetalHeartRate, Double height, String investigations, String medicines, Double muac, String note, Boolean opd, String patientType, Double pulse, String purpose, Double respiratoryRate, String tbScreened, Double temperature, String visitOutcome, Double weight, PersonDemographic personDemographic) {
        this.patientId = patientId;
        this.siteId = siteId;
        this.dangerSigns = dangerSigns;
        this.admissionTime = admissionTime;
        this.bloodPressure = bloodPressure;
        this.complaints = complaints;
        this.date = date;
        this.diagnoses = diagnoses;
        this.discharged = discharged;
        this.examinations = examinations;
        this.fetalHeartRate = fetalHeartRate;
        this.height = height;
        this.investigations = investigations;
        this.medicines = medicines;
        this.muac = muac;
        this.note = note;
        this.opd = opd;
        this.patientType = patientType;
        this.pulse = pulse;
        this.purpose = purpose;
        this.respiratoryRate = respiratoryRate;
        this.tbScreened = tbScreened;
        this.temperature = temperature;
        this.visitOutcome = visitOutcome;
        this.weight = weight;
        this.personDemographic = personDemographic;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getDangerSigns() {
        return dangerSigns;
    }

    public void setDangerSigns(String dangerSigns) {
        this.dangerSigns = dangerSigns;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Boolean getDischarged() {
        return discharged;
    }

    public void setDischarged(Boolean discharged) {
        this.discharged = discharged;
    }

    public String getExaminations() {
        return examinations;
    }

    public void setExaminations(String examinations) {
        this.examinations = examinations;
    }

    public String getFetalHeartRate() {
        return fetalHeartRate;
    }

    public void setFetalHeartRate(String fetalHeartRate) {
        this.fetalHeartRate = fetalHeartRate;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getInvestigations() {
        return investigations;
    }

    public void setInvestigations(String investigations) {
        this.investigations = investigations;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public Double getMuac() {
        return muac;
    }

    public void setMuac(Double muac) {
        this.muac = muac;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getOpd() {
        return opd;
    }

    public void setOpd(Boolean opd) {
        this.opd = opd;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public Double getPulse() {
        return pulse;
    }

    public void setPulse(Double pulse) {
        this.pulse = pulse;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(Double respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public String getTbScreened() {
        return tbScreened;
    }

    public void setTbScreened(String tbScreened) {
        this.tbScreened = tbScreened;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getVisitOutcome() {
        return visitOutcome;
    }

    public void setVisitOutcome(String visitOutcome) {
        this.visitOutcome = visitOutcome;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public PersonDemographic getPersonDemographic() {
        return personDemographic;
    }

    public void setPersonDemographic(PersonDemographic personDemographic) {
        this.personDemographic = personDemographic;
    }
}

