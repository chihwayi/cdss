package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "investigation_register")
public class InvestigationRegister {

    @Id
    @Column(name = "laboratory_investigation_id")
    private String laboratoryInvestigationId;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "date_result_issued")
    @Temporal(TemporalType.DATE)
    private Date dateResultIssued;

    @Column(name = "facility_id")
    private String facilityId;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "investigation_id")
    private String investigationId;

    @Column(name = "investigation_type")
    private String investigationType;

    @Column(name = "month")
    private int month;

    @Column(name = "note")
    private String note;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "result")
    private String result;

    @Column(name = "result_date")
    @Temporal(TemporalType.DATE)
    private Date resultDate;

    @Column(name = "result_issued")
    private Boolean resultIssued; // Use Boolean for bit(1)

    @Column(name = "sample_id")
    private String sampleId;

    @Column(name = "sample")
    private String sample;

    @Column(name = "site_id")
    private String siteId;

    @Column(name = "status")
    private String status;

    @Column(name = "test_id")
    private String testId;

    @Column(name = "test")
    private String test;

    @Column(name = "year")
    private int year;

    public String getLaboratoryInvestigationId() {
        return laboratoryInvestigationId;
    }

    public void setLaboratoryInvestigationId(String laboratoryInvestigationId) {
        this.laboratoryInvestigationId = laboratoryInvestigationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateResultIssued() {
        return dateResultIssued;
    }

    public void setDateResultIssued(Date dateResultIssued) {
        this.dateResultIssued = dateResultIssued;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getInvestigationId() {
        return investigationId;
    }

    public void setInvestigationId(String investigationId) {
        this.investigationId = investigationId;
    }

    public String getInvestigationType() {
        return investigationType;
    }

    public void setInvestigationType(String investigationType) {
        this.investigationType = investigationType;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }

    public Boolean getResultIssued() {
        return resultIssued;
    }

    public void setResultIssued(Boolean resultIssued) {
        this.resultIssued = resultIssued;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
