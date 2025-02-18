package zw.org.mohcc.cdss.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "art_register")
public class ArtRegister {
    @Id
    @Column(name = "art_id")
    private String artId;

    @Column(name = "site_id")
    private String siteId;

    @Column(name = "art_cohort_number")
    private String artCohortNumber;

    @Column(name = "art_number")
    private String artNumber;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "central_nervous_system")
    private String centralNervousSystem;

    @Column(name = "consent_to_personal_follow_up")
    private Boolean consentToPersonalFollowUp;

    @Column(name = "cyanosis")
    private Boolean cyanosis;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "date_enrolled")
    @Temporal(TemporalType.DATE)
    private Date dateEnrolled;

    @Column(name = "date_of_hiv_test")
    @Temporal(TemporalType.DATE)
    private Date dateOfHivTest;

    @Column(name = "enlarged_lymph_node")
    private Boolean enlargedLymphNode;

    @Column(name = "hpv_test_result")
    private String hpvTestResult;

    @Column(name = "hpv_viac_treatment")
    private String hpvViacTreatment;

    @Column(name = "jaundice")
    private Boolean jaundice;

    @Column(name = "mental_status")
    private String mentalStatus;

    @Column(name = "month")
    private int month;

    @Column(name = "pallor")
    private Boolean pallor;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "sex")
    private String sex;

    @Column(name = "viac_result")
    private String viacResult;

    @Column(name = "year")
    private int year;


    @OneToMany(mappedBy = "artRegister", cascade = CascadeType.ALL)
    private List<ArtCurrentStatusRegister> artCurrentStatusRegisters;

    @OneToMany(mappedBy = "artRegister", cascade = CascadeType.ALL)
    private List<ArtWhoStageRegister> artWhoStageRegisters;

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getArtCohortNumber() {
        return artCohortNumber;
    }

    public void setArtCohortNumber(String artCohortNumber) {
        this.artCohortNumber = artCohortNumber;
    }

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCentralNervousSystem() {
        return centralNervousSystem;
    }

    public void setCentralNervousSystem(String centralNervousSystem) {
        this.centralNervousSystem = centralNervousSystem;
    }

    public Boolean getConsentToPersonalFollowUp() {
        return consentToPersonalFollowUp;
    }

    public void setConsentToPersonalFollowUp(Boolean consentToPersonalFollowUp) {
        this.consentToPersonalFollowUp = consentToPersonalFollowUp;
    }

    public Boolean getCyanosis() {
        return cyanosis;
    }

    public void setCyanosis(Boolean cyanosis) {
        this.cyanosis = cyanosis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public Date getDateOfHivTest() {
        return dateOfHivTest;
    }

    public void setDateOfHivTest(Date dateOfHivTest) {
        this.dateOfHivTest = dateOfHivTest;
    }

    public Boolean getEnlargedLymphNode() {
        return enlargedLymphNode;
    }

    public void setEnlargedLymphNode(Boolean enlargedLymphNode) {
        this.enlargedLymphNode = enlargedLymphNode;
    }

    public String getHpvTestResult() {
        return hpvTestResult;
    }

    public void setHpvTestResult(String hpvTestResult) {
        this.hpvTestResult = hpvTestResult;
    }

    public String getHpvViacTreatment() {
        return hpvViacTreatment;
    }

    public void setHpvViacTreatment(String hpvViacTreatment) {
        this.hpvViacTreatment = hpvViacTreatment;
    }

    public Boolean getJaundice() {
        return jaundice;
    }

    public void setJaundice(Boolean jaundice) {
        this.jaundice = jaundice;
    }

    public String getMentalStatus() {
        return mentalStatus;
    }

    public void setMentalStatus(String mentalStatus) {
        this.mentalStatus = mentalStatus;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Boolean getPallor() {
        return pallor;
    }

    public void setPallor(Boolean pallor) {
        this.pallor = pallor;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getViacResult() {
        return viacResult;
    }

    public void setViacResult(String viacResult) {
        this.viacResult = viacResult;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<ArtCurrentStatusRegister> getArtCurrentStatusRegisters() {
        return artCurrentStatusRegisters;
    }

    public void setArtCurrentStatusRegisters(List<ArtCurrentStatusRegister> artCurrentStatusRegisters) {
        this.artCurrentStatusRegisters = artCurrentStatusRegisters;
    }

    public List<ArtWhoStageRegister> getArtWhoStageRegisters() {
        return artWhoStageRegisters;
    }

    public void setArtWhoStageRegisters(List<ArtWhoStageRegister> artWhoStageRegisters) {
        this.artWhoStageRegisters = artWhoStageRegisters;
    }
}