package zw.org.mohcc.cdss.model.dto;

import java.time.LocalDate;

public class WhoStage {
    private LocalDate date;
    private String artStageId;
    private String whoStage;
    private String followUpStatus;

    public WhoStage() {
    }

    public WhoStage(LocalDate date, String artStageId, String whoStage, String followUpStatus) {
        this.date = date;
        this.artStageId = artStageId;
        this.whoStage = whoStage;
        this.followUpStatus = followUpStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getArtStageId() {
        return artStageId;
    }

    public void setArtStageId(String artStageId) {
        this.artStageId = artStageId;
    }

    public String getWhoStage() {
        return whoStage;
    }

    public void setWhoStage(String whoStage) {
        this.whoStage = whoStage;
    }

    public String getFollowUpStatus() {
        return followUpStatus;
    }

    public void setFollowUpStatus(String followUpStatus) {
        this.followUpStatus = followUpStatus;
    }
}
