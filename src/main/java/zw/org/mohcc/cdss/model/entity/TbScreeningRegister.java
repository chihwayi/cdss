package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_screening_register")
public class TbScreeningRegister {
    @Id
    @Column(name = "patient_tb_screening_id")
    private String patientTbScreeningId;

    @Column(name = "bmi_under_seventeen")
    private Boolean bmiUnderSeventeen;

    @Column(name = "coughing")
    private Boolean coughing;

    @Column(name = "date")
    private Date date;

    @Column(name = "fever")
    private Boolean fever;

    @Column(name = "night_sweats")
    private Boolean nightSweats;

    @Column(name = "note")
    private String note;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "presumptive")
    private Boolean presumptive;

    @Column(name = "site_id")
    private String siteId;

    @Column(name = "weight_loss")
    private Boolean weightLoss;

    @ManyToOne
    @JoinColumn(name = "demographic_person_id")
    private PersonDemographic personDemographic;

    public TbScreeningRegister() {
    }

    public TbScreeningRegister(String patientTbScreeningId, Boolean bmiUnderSeventeen, Boolean coughing, Date date, Boolean fever, Boolean nightSweats, String note, String patientId, Boolean presumptive, String siteId, Boolean weightLoss, PersonDemographic personDemographic) {
        this.patientTbScreeningId = patientTbScreeningId;
        this.bmiUnderSeventeen = bmiUnderSeventeen;
        this.coughing = coughing;
        this.date = date;
        this.fever = fever;
        this.nightSweats = nightSweats;
        this.note = note;
        this.patientId = patientId;
        this.presumptive = presumptive;
        this.siteId = siteId;
        this.weightLoss = weightLoss;
        this.personDemographic = personDemographic;
    }

    public String getPatientTbScreeningId() {
        return patientTbScreeningId;
    }

    public void setPatientTbScreeningId(String patientTbScreeningId) {
        this.patientTbScreeningId = patientTbScreeningId;
    }

    public Boolean getBmiUnderSeventeen() {
        return bmiUnderSeventeen;
    }

    public void setBmiUnderSeventeen(Boolean bmiUnderSeventeen) {
        this.bmiUnderSeventeen = bmiUnderSeventeen;
    }

    public Boolean getCoughing() {
        return coughing;
    }

    public void setCoughing(Boolean coughing) {
        this.coughing = coughing;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean getNightSweats() {
        return nightSweats;
    }

    public void setNightSweats(Boolean nightSweats) {
        this.nightSweats = nightSweats;
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

    public Boolean getPresumptive() {
        return presumptive;
    }

    public void setPresumptive(Boolean presumptive) {
        this.presumptive = presumptive;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Boolean getWeightLoss() {
        return weightLoss;
    }

    public void setWeightLoss(Boolean weightLoss) {
        this.weightLoss = weightLoss;
    }

    public PersonDemographic getPersonDemographic() {
        return personDemographic;
    }

    public void setPersonDemographic(PersonDemographic personDemographic) {
        this.personDemographic = personDemographic;
    }
}
