package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_visit_register")
public class TbVisitRegister {
    @Id
    @Column(name = "tb_visit_id")
    private String tbVisitId;

    @Column(name = "site_id")
    private String siteId;

    @Column(name = "date")
    private Date date;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientRegister patientRegister;

    @Column(name = "tb")
    private String tb;

    public TbVisitRegister() {
    }

    public TbVisitRegister(String tbVisitId, String siteId, Date date, Integer month, Integer year, PatientRegister patientRegister, String tb) {
        this.tbVisitId = tbVisitId;
        this.siteId = siteId;
        this.date = date;
        this.month = month;
        this.year = year;
        this.patientRegister = patientRegister;
        this.tb = tb;
    }

    public String getTbVisitId() {
        return tbVisitId;
    }

    public void setTbVisitId(String tbVisitId) {
        this.tbVisitId = tbVisitId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public PatientRegister getPatientRegister() {
        return patientRegister;
    }

    public void setPatientRegister(PatientRegister patientRegister) {
        this.patientRegister = patientRegister;
    }

    public String getTb() {
        return tb;
    }

    public void setTb(String tb) {
        this.tb = tb;
    }
}

