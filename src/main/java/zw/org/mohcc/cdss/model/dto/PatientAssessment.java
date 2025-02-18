package zw.org.mohcc.cdss.model.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class PatientAssessment {
    private String hivStatus;
    private String currentArtStatus;
    private String state;
    private String reason;
    private Double cd4Count; // Changed to Double for easier parsing
    private Boolean onArt = false; // Initialize with default value
    private Integer monthsOnArt;
    private Double lastViralLoad;
    private Integer monthsSinceLastViralLoad;
    private String personId; // Added to match with entities

    private List<String> whoStages = new ArrayList<>();
    private List<ClinicalAlert> alerts = new ArrayList<>();
    private TreatmentRecommendation recommendation;

    public boolean hasWHOStage(String stage) {
        return whoStages.contains(stage);
    }

    public boolean hasViralLoadTest(Integer months) {
        return monthsSinceLastViralLoad != null && monthsSinceLastViralLoad <= months;
    }

    public void addAlert(ClinicalAlert alert) {
        if (alerts == null) {
            alerts = new ArrayList<>();
        }
        alerts.add(alert);
    }

    // Added explicit setters for Drools
    public void setHivStatus(String status) {
        this.hivStatus = status;
    }

    public void setCd4Count(Double count) {
        this.cd4Count = count;
    }

    public void setLastViralLoad(Double load) {
        this.lastViralLoad = load;
    }

    public void setMonthsSinceLastViralLoad(Integer months) {
        this.monthsSinceLastViralLoad = months;
    }

    public void setRecommendation(TreatmentRecommendation rec) {
        this.recommendation = rec;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getHivStatus() {
        return hivStatus;
    }

    public String getCurrentArtStatus() {
        return currentArtStatus;
    }

    public void setCurrentArtStatus(String currentArtStatus) {
        this.currentArtStatus = currentArtStatus;
    }

    public Double getCd4Count() {
        return cd4Count;
    }

    public Boolean getOnArt() {
        return onArt;
    }

    public void setOnArt(Boolean onArt) {
        this.onArt = onArt;
    }

    public Integer getMonthsOnArt() {
        return monthsOnArt;
    }

    public void setMonthsOnArt(Integer monthsOnArt) {
        this.monthsOnArt = monthsOnArt;
    }

    public Double getLastViralLoad() {
        return lastViralLoad;
    }

    public Integer getMonthsSinceLastViralLoad() {
        return monthsSinceLastViralLoad;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<String> getWhoStages() {
        return whoStages;
    }

    public void setWhoStages(List<String> whoStages) {
        this.whoStages = whoStages;
    }

    public List<ClinicalAlert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<ClinicalAlert> alerts) {
        this.alerts = alerts;
    }

    public TreatmentRecommendation getRecommendation() {
        return recommendation;
    }

    public void setClinicalAlerts(List<ClinicalAlert> clinicalAlerts) {
    }

    public void setTreatmentAlerts(List<TreatmentAlert> treatmentAlerts) {
    }

    public void setHistoricalViralLoads(List<Double> historicalViralLoads) {
    }
}
