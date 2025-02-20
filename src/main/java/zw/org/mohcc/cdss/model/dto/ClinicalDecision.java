package zw.org.mohcc.cdss.model.dto;

import java.time.LocalDate;

public class ClinicalDecision {
    private String recommendationType;
    private String recommendation;
    private String urgency; // HIGH, MEDIUM, LOW
    private String rationale;
    private LocalDate evaluationDate;

    public ClinicalDecision() {
    }

    public ClinicalDecision(String recommendationType, String recommendation, String urgency, String rationale, LocalDate evaluationDate) {
        this.recommendationType = recommendationType;
        this.recommendation = recommendation;
        this.urgency = urgency;
        this.rationale = rationale;
        this.evaluationDate = evaluationDate;
    }

    public String getRecommendationType() {
        return recommendationType;
    }

    public void setRecommendationType(String recommendationType) {
        this.recommendationType = recommendationType;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
