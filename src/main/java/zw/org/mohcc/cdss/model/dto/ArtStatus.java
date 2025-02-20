package zw.org.mohcc.cdss.model.dto;

import java.time.LocalDate;
import java.util.List;

public class ArtStatus {
    private LocalDate date;
    private String reason;
    private String artStatusId;
    private List<WhoStage> whoStages;
    private String reasonForRegimenSubstitution;
    private List<Investigation> investigations;
    private String regimenFrom;
    private String treatmentFailureReason;
    private String adverseEventStatus;
    private String regimenLineFromName;
    private String state;
    private String regimenLineName;
    private String regimen;

    public ArtStatus() {
    }

    public ArtStatus(LocalDate date, String reason, String artStatusId, List<WhoStage> whoStages, String reasonForRegimenSubstitution, List<Investigation> investigations, String regimenFrom, String treatmentFailureReason, String adverseEventStatus, String regimenLineFromName, String state, String regimenLineName, String regimen) {
        this.date = date;
        this.reason = reason;
        this.artStatusId = artStatusId;
        this.whoStages = whoStages;
        this.reasonForRegimenSubstitution = reasonForRegimenSubstitution;
        this.investigations = investigations;
        this.regimenFrom = regimenFrom;
        this.treatmentFailureReason = treatmentFailureReason;
        this.adverseEventStatus = adverseEventStatus;
        this.regimenLineFromName = regimenLineFromName;
        this.state = state;
        this.regimenLineName = regimenLineName;
        this.regimen = regimen;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getArtStatusId() {
        return artStatusId;
    }

    public void setArtStatusId(String artStatusId) {
        this.artStatusId = artStatusId;
    }

    public List<WhoStage> getWhoStages() {
        return whoStages;
    }

    public void setWhoStages(List<WhoStage> whoStages) {
        this.whoStages = whoStages;
    }

    public String getReasonForRegimenSubstitution() {
        return reasonForRegimenSubstitution;
    }

    public void setReasonForRegimenSubstitution(String reasonForRegimenSubstitution) {
        this.reasonForRegimenSubstitution = reasonForRegimenSubstitution;
    }

    public List<Investigation> getInvestigations() {
        return investigations;
    }

    public void setInvestigations(List<Investigation> investigations) {
        this.investigations = investigations;
    }

    public String getRegimenFrom() {
        return regimenFrom;
    }

    public void setRegimenFrom(String regimenFrom) {
        this.regimenFrom = regimenFrom;
    }

    public String getTreatmentFailureReason() {
        return treatmentFailureReason;
    }

    public void setTreatmentFailureReason(String treatmentFailureReason) {
        this.treatmentFailureReason = treatmentFailureReason;
    }

    public String getAdverseEventStatus() {
        return adverseEventStatus;
    }

    public void setAdverseEventStatus(String adverseEventStatus) {
        this.adverseEventStatus = adverseEventStatus;
    }

    public String getRegimenLineFromName() {
        return regimenLineFromName;
    }

    public void setRegimenLineFromName(String regimenLineFromName) {
        this.regimenLineFromName = regimenLineFromName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRegimenLineName() {
        return regimenLineName;
    }

    public void setRegimenLineName(String regimenLineName) {
        this.regimenLineName = regimenLineName;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }
}
