package zw.org.mohcc.cdss.model.dto;

import lombok.Data;

@Data
public class TreatmentRecommendation {
    private String code;
    private String description;
    private String recommendedRegimen;

    public TreatmentRecommendation() {
    }

    public TreatmentRecommendation(String code, String description, String recommendedRegimen) {
        this.code = code;
        this.description = description;
        this.recommendedRegimen = recommendedRegimen;
    }


}
