package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "person_demographic")
public class PersonDemographic {
    @Id
    @Column(name = "person_id")
    private String personId;

    @Column(name = "address")
    private String address;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "country_of_birth")
    private String countryOfBirth;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "education")
    private String education;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "marital")
    private String marital;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "religion")
    private String religion;

    @Column(name = "self_identified_gender")
    private String selfIdentifiedGender;

    @Column(name = "sex")
    private String sex;

    public PersonDemographic() {
    }

    public PersonDemographic(String personId, String address, Date birthdate, String countryOfBirth, String denomination, String education, String firstname, String lastname, String marital, String nationality, String occupation, String phoneNumber, String religion, String selfIdentifiedGender, String sex) {
        this.personId = personId;
        this.address = address;
        this.birthdate = birthdate;
        this.countryOfBirth = countryOfBirth;
        this.denomination = denomination;
        this.education = education;
        this.firstname = firstname;
        this.lastname = lastname;
        this.marital = marital;
        this.nationality = nationality;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.religion = religion;
        this.selfIdentifiedGender = selfIdentifiedGender;
        this.sex = sex;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSelfIdentifiedGender() {
        return selfIdentifiedGender;
    }

    public void setSelfIdentifiedGender(String selfIdentifiedGender) {
        this.selfIdentifiedGender = selfIdentifiedGender;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

