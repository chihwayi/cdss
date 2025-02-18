package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "art_who_stage_register")
public class ArtWhoStageRegister {

    @Id
    @Column(name = "art_stage_id")
    private String artStageId;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "follow_up_status_id")
    private String followUpStatusId;

    @Column(name = "follow_up_status")
    private String followUpStatus;

    @Column(name = "month")
    private int month;

    @Column(name = "stage")
    private String stage;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "art_register_id")
    private ArtRegister artRegister;

    public String getArtStageId() {
        return artStageId;
    }

    public void setArtStageId(String artStageId) {
        this.artStageId = artStageId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFollowUpStatusId() {
        return followUpStatusId;
    }

    public void setFollowUpStatusId(String followUpStatusId) {
        this.followUpStatusId = followUpStatusId;
    }

    public String getFollowUpStatus() {
        return followUpStatus;
    }

    public void setFollowUpStatus(String followUpStatus) {
        this.followUpStatus = followUpStatus;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
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
