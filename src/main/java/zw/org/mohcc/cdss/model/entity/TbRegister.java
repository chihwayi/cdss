package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_register")
public class TbRegister {
    @Id
    @Column(name = "tb_id")
    private String tbId;

    @Column(name = "site_id")
    private String siteId;

    @Column(name = "category")
    private String category;

    @Column(name = "client_referral_type")
    private String clientReferralType;

    @Column(name = "date")
    private Date date;

    @Column(name = "diagnosis_id")
    private String diagnosisId;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "diagnosis_date")
    private Date diagnosisDate;

    @Column(name = "extra_pulmonary_site")
    private String extraPulmonarySite;

    @Column(name = "family_dot")
    private String familyDot;

    @Column(name = "month")
    private Integer month;

    @Column(name = "next_of_kin_address")
    private String nextOfKinAddress;

    @Column(name = "next_of_kin_full_name")
    private String nextOfKinFullName;

    @Column(name = "next_of_kin_phone_number")
    private String nextOfKinPhoneNumber;

    @Column(name = "out_come_date")
    private Date outComeDate;

    @Column(name = "outcome")
    private String outcome;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "person_investigation_id")
    private String personInvestigationId;

    @Column(name = "pre_treatment_lab_results")
    private String preTreatmentLabResults;

    @Column(name = "resistant_to")
    private String resistantTo;

    @Column(name = "tb_disease_site")
    private String tbDiseaseSite;

    @Column(name = "tb_disease_type")
    private String tbDiseaseType;

    @Column(name = "tb_number")
    private String tbNumber;

    @Column(name = "tb_sensitivity")
    private String tbSensitivity;

    @Column(name = "tb_type_dot")
    private String tbTypeDot;

    @Column(name = "transfer_from")
    private String transferFrom;

    @Column(name = "treatment_start_date")
    private Date treatmentStartDate;

    @Column(name = "treatment_type")
    private String treatmentType;

    @Column(name = "type")
    private String type;

    @Column(name = "type_of_tb")
    private String typeOfTb;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonDemographic personDemographic;

    public TbRegister() {
    }

    public TbRegister(String tbId, String siteId, String category, String clientReferralType, Date date, String diagnosisId, String diagnosis, Date diagnosisDate, String extraPulmonarySite, String familyDot, Integer month, String nextOfKinAddress, String nextOfKinFullName, String nextOfKinPhoneNumber, Date outComeDate, String outcome, String patientId, String personInvestigationId, String preTreatmentLabResults, String resistantTo, String tbDiseaseSite, String tbDiseaseType, String tbNumber, String tbSensitivity, String tbTypeDot, String transferFrom, Date treatmentStartDate, String treatmentType, String type, String typeOfTb, Integer year, PersonDemographic personDemographic) {
        this.tbId = tbId;
        this.siteId = siteId;
        this.category = category;
        this.clientReferralType = clientReferralType;
        this.date = date;
        this.diagnosisId = diagnosisId;
        this.diagnosis = diagnosis;
        this.diagnosisDate = diagnosisDate;
        this.extraPulmonarySite = extraPulmonarySite;
        this.familyDot = familyDot;
        this.month = month;
        this.nextOfKinAddress = nextOfKinAddress;
        this.nextOfKinFullName = nextOfKinFullName;
        this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
        this.outComeDate = outComeDate;
        this.outcome = outcome;
        this.patientId = patientId;
        this.personInvestigationId = personInvestigationId;
        this.preTreatmentLabResults = preTreatmentLabResults;
        this.resistantTo = resistantTo;
        this.tbDiseaseSite = tbDiseaseSite;
        this.tbDiseaseType = tbDiseaseType;
        this.tbNumber = tbNumber;
        this.tbSensitivity = tbSensitivity;
        this.tbTypeDot = tbTypeDot;
        this.transferFrom = transferFrom;
        this.treatmentStartDate = treatmentStartDate;
        this.treatmentType = treatmentType;
        this.type = type;
        this.typeOfTb = typeOfTb;
        this.year = year;
        this.personDemographic = personDemographic;
    }

    public String getTbId() {
        return tbId;
    }

    public void setTbId(String tbId) {
        this.tbId = tbId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClientReferralType() {
        return clientReferralType;
    }

    public void setClientReferralType(String clientReferralType) {
        this.clientReferralType = clientReferralType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getExtraPulmonarySite() {
        return extraPulmonarySite;
    }

    public void setExtraPulmonarySite(String extraPulmonarySite) {
        this.extraPulmonarySite = extraPulmonarySite;
    }

    public String getFamilyDot() {
        return familyDot;
    }

    public void setFamilyDot(String familyDot) {
        this.familyDot = familyDot;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getNextOfKinAddress() {
        return nextOfKinAddress;
    }

    public void setNextOfKinAddress(String nextOfKinAddress) {
        this.nextOfKinAddress = nextOfKinAddress;
    }

    public String getNextOfKinFullName() {
        return nextOfKinFullName;
    }

    public void setNextOfKinFullName(String nextOfKinFullName) {
        this.nextOfKinFullName = nextOfKinFullName;
    }

    public String getNextOfKinPhoneNumber() {
        return nextOfKinPhoneNumber;
    }

    public void setNextOfKinPhoneNumber(String nextOfKinPhoneNumber) {
        this.nextOfKinPhoneNumber = nextOfKinPhoneNumber;
    }

    public Date getOutComeDate() {
        return outComeDate;
    }

    public void setOutComeDate(Date outComeDate) {
        this.outComeDate = outComeDate;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPersonInvestigationId() {
        return personInvestigationId;
    }

    public void setPersonInvestigationId(String personInvestigationId) {
        this.personInvestigationId = personInvestigationId;
    }

    public String getPreTreatmentLabResults() {
        return preTreatmentLabResults;
    }

    public void setPreTreatmentLabResults(String preTreatmentLabResults) {
        this.preTreatmentLabResults = preTreatmentLabResults;
    }

    public String getResistantTo() {
        return resistantTo;
    }

    public void setResistantTo(String resistantTo) {
        this.resistantTo = resistantTo;
    }

    public String getTbDiseaseSite() {
        return tbDiseaseSite;
    }

    public void setTbDiseaseSite(String tbDiseaseSite) {
        this.tbDiseaseSite = tbDiseaseSite;
    }

    public String getTbDiseaseType() {
        return tbDiseaseType;
    }

    public void setTbDiseaseType(String tbDiseaseType) {
        this.tbDiseaseType = tbDiseaseType;
    }

    public String getTbNumber() {
        return tbNumber;
    }

    public void setTbNumber(String tbNumber) {
        this.tbNumber = tbNumber;
    }

    public String getTbSensitivity() {
        return tbSensitivity;
    }

    public void setTbSensitivity(String tbSensitivity) {
        this.tbSensitivity = tbSensitivity;
    }

    public String getTbTypeDot() {
        return tbTypeDot;
    }

    public void setTbTypeDot(String tbTypeDot) {
        this.tbTypeDot = tbTypeDot;
    }

    public String getTransferFrom() {
        return transferFrom;
    }

    public void setTransferFrom(String transferFrom) {
        this.transferFrom = transferFrom;
    }

    public Date getTreatmentStartDate() {
        return treatmentStartDate;
    }

    public void setTreatmentStartDate(Date treatmentStartDate) {
        this.treatmentStartDate = treatmentStartDate;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeOfTb() {
        return typeOfTb;
    }

    public void setTypeOfTb(String typeOfTb) {
        this.typeOfTb = typeOfTb;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public PersonDemographic getPersonDemographic() {
        return personDemographic;
    }

    public void setPersonDemographic(PersonDemographic personDemographic) {
        this.personDemographic = personDemographic;
    }
}
