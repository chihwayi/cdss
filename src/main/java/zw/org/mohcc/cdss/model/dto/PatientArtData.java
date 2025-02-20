package zw.org.mohcc.cdss.model.dto;

import java.time.LocalDate;
import java.util.List;

public class PatientArtData {
    private String personId;
    private LocalDate birthDate;
    private LocalDate dateOfHivTest;
    private LocalDate dateEnrolled;
    private String sex;
    private String artNumber;
    private String siteId;
    private List<ArtStatus> statuses;

    public PatientArtData() {
    }

    public PatientArtData(String personId, LocalDate birthDate, LocalDate dateOfHivTest, LocalDate dateEnrolled, String sex, String artNumber, String siteId, List<ArtStatus> statuses) {
        this.personId = personId;
        this.birthDate = birthDate;
        this.dateOfHivTest = dateOfHivTest;
        this.dateEnrolled = dateEnrolled;
        this.sex = sex;
        this.artNumber = artNumber;
        this.siteId = siteId;
        this.statuses = statuses;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDateOfHivTest() {
        return dateOfHivTest;
    }

    public void setDateOfHivTest(LocalDate dateOfHivTest) {
        this.dateOfHivTest = dateOfHivTest;
    }

    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDate dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public List<ArtStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<ArtStatus> statuses) {
        this.statuses = statuses;
    }
}
