package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "art_current_status_register")
public class ArtCurrentStatusRegister {

    @Id
    @Column(name = "art_status_id")
    private String artStatusId;

    @Column(name = "adverse_event_status_id")
    private String adverseEventStatusId;

    @Column(name = "adverse_event_status")
    private String adverseEventStatus;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "month")
    private int month;

    @Column(name = "reason_id")
    private String reasonId;

    @Column(name = "reason")
    private String reason;

    @Column(name = "reason_for_regimen_substitution_id")
    private String reasonForRegimenSubstitutionId;

    @Column(name = "reason_for_regimen_substitution")
    private String reasonForRegimenSubstitution;

    @Column(name = "regimen_id")
    private String regimenId;

    @Column(name = "regimen")
    private String regimen;

    @Column(name = "regimen_from_id")
    private String regimenFromId;

    @Column(name = "regimen_from")
    private String regimenFrom;

    @Column(name = "regimen_line_from_name")
    private String regimenLineFromName;

    @Column(name = "regimen_line_name")
    private String regimenLineName;

    @Column(name = "state")
    private String state;

    @Column(name = "treatment_failure_reason_id")
    private String treatmentFailureReasonId;

    @Column(name = "treatment_failure_reason")
    private String treatmentFailureReason;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "art_register_id")
    private ArtRegister artRegister;

    public String getArtStatusId() {
        return artStatusId;
    }

    public void setArtStatusId(String artStatusId) {
        this.artStatusId = artStatusId;
    }

    public String getAdverseEventStatusId() {
        return adverseEventStatusId;
    }

    public void setAdverseEventStatusId(String adverseEventStatusId) {
        this.adverseEventStatusId = adverseEventStatusId;
    }

    public String getAdverseEventStatus() {
        return adverseEventStatus;
    }

    public void setAdverseEventStatus(String adverseEventStatus) {
        this.adverseEventStatus = adverseEventStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReasonForRegimenSubstitutionId() {
        return reasonForRegimenSubstitutionId;
    }

    public void setReasonForRegimenSubstitutionId(String reasonForRegimenSubstitutionId) {
        this.reasonForRegimenSubstitutionId = reasonForRegimenSubstitutionId;
    }

    public String getReasonForRegimenSubstitution() {
        return reasonForRegimenSubstitution;
    }

    public void setReasonForRegimenSubstitution(String reasonForRegimenSubstitution) {
        this.reasonForRegimenSubstitution = reasonForRegimenSubstitution;
    }

    public String getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(String regimenId) {
        this.regimenId = regimenId;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getRegimenFromId() {
        return regimenFromId;
    }

    public void setRegimenFromId(String regimenFromId) {
        this.regimenFromId = regimenFromId;
    }

    public String getRegimenFrom() {
        return regimenFrom;
    }

    public void setRegimenFrom(String regimenFrom) {
        this.regimenFrom = regimenFrom;
    }

    public String getRegimenLineFromName() {
        return regimenLineFromName;
    }

    public void setRegimenLineFromName(String regimenLineFromName) {
        this.regimenLineFromName = regimenLineFromName;
    }

    public String getRegimenLineName() {
        return regimenLineName;
    }

    public void setRegimenLineName(String regimenLineName) {
        this.regimenLineName = regimenLineName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTreatmentFailureReasonId() {
        return treatmentFailureReasonId;
    }

    public void setTreatmentFailureReasonId(String treatmentFailureReasonId) {
        this.treatmentFailureReasonId = treatmentFailureReasonId;
    }

    public String getTreatmentFailureReason() {
        return treatmentFailureReason;
    }

    public void setTreatmentFailureReason(String treatmentFailureReason) {
        this.treatmentFailureReason = treatmentFailureReason;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArtRegister getArtRegister() {
        return artRegister;
    }

    public void setArtRegister(ArtRegister artRegister) {
        this.artRegister = artRegister;
    }
}
