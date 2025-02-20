package zw.org.mohcc.cdss.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cbs_register")
public class CbsRegister {
    @Id
    @Size(max = 255)
    @Column(name = "person_id", nullable = false)
    private String personId;

    @Size(max = 255)
    @Column(name = "site_id")
    private String siteId;

    @Size(max = 255)
    @Column(name = "result")
    private String result;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @Size(max = 255)
    @Column(name = "art_reason_not_initiated")
    private String artReasonNotInitiated;

    @Size(max = 255)
    @Column(name = "art_regimen")
    private String artRegimen;

    @Size(max = 255)
    @Column(name = "art_regimen_monther")
    private String artRegimenMonther;

    @Size(max = 255)
    @Column(name = "art_status_mother")
    private String artStatusMother;

    @Size(max = 255)
    @Column(name = "been_incarcerated_into_jail")
    private String beenIncarceratedIntoJail;

    @Column(name = "biological_mother_alive")
    private Boolean biologicalMotherAlive;

    @Size(max = 255)
    @Column(name = "birth_defect")
    private String birthDefect;

    @Column(name = "birth_weight")
    private Integer birthWeight;

    @Column(name = "breast_feeding")
    private Boolean breastFeeding;

    @Size(max = 255)
    @Column(name = "cbs_id")
    private String cbsId;

    @Size(max = 255)
    @Column(name = "cd4at_notification")
    private String cd4atNotification;

    @Column(name = "cd4count")
    private Integer cd4count;

    @Size(max = 255)
    @Column(name = "contact_of_index_case")
    private String contactOfIndexCase;

    @Column(name = "currently_breastfeeding_infant")
    private Boolean currentlyBreastfeedingInfant;

    @Size(max = 255)
    @Column(name = "currently_on_art")
    private String currentlyOnArt;

    @Column(name = "date_of_diagnosis")
    private LocalDate dateOfDiagnosis;

    @Column(name = "date_of_initiation")
    private LocalDate dateOfInitiation;

    @Column(name = "date_of_most_recent_hiv_result")
    private LocalDate dateOfMostRecentHivResult;

    @Size(max = 255)
    @Column(name = "delivered_by")
    private String deliveredBy;

    @Size(max = 255)
    @Column(name = "education")
    private String education;

    @Size(max = 255)
    @Column(name = "ever_been_on_arvart_excluding_prep")
    private String everBeenOnArvartExcludingPrep;

    @Size(max = 255)
    @Column(name = "exclusive_breast_feeding_duration")
    private String exclusiveBreastFeedingDuration;

    @Size(max = 255)
    @Column(name = "gender")
    private String gender;

    @Column(name = "gender_at_birth")
    private Integer genderAtBirth;

    @Column(name = "gestation")
    private Integer gestation;

    @Column(name = "gestation_atbooking")
    private Integer gestationAtbooking;

    @Size(max = 255)
    @Column(name = "had_sex_for_money_or_goods")
    private String hadSexForMoneyOrGoods;

    @Size(max = 255)
    @Column(name = "had_sex_with_female")
    private String hadSexWithFemale;

    @Size(max = 255)
    @Column(name = "had_sex_with_male")
    private String hadSexWithMale;

    @Size(max = 255)
    @Column(name = "have_you_ever_been_on_prep")
    private String haveYouEverBeenOnPrep;

    @Size(max = 255)
    @Column(name = "highest_level_of_education")
    private String highestLevelOfEducation;

    @Size(max = 255)
    @Column(name = "history_of_an_sti")
    private String historyOfAnSti;

    @Size(max = 255)
    @Column(name = "index_case_hts_number")
    private String indexCaseHtsNumber;

    @Size(max = 255)
    @Column(name = "initiated_art")
    private String initiatedArt;

    @Size(max = 255)
    @Column(name = "injected_recreational_drugs")
    private String injectedRecreationalDrugs;

    @Size(max = 255)
    @Column(name = "investigation_id")
    private String investigationId;

    @Size(max = 255)
    @Column(name = "investigation_order_id")
    private String investigationOrderId;

    @Size(max = 255)
    @Column(name = "marital_status")
    private String maritalStatus;

    @Size(max = 255)
    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "not_pregnant_orbreastfeeding")
    private Boolean notPregnantOrbreastfeeding;

    @Column(name = "number_of_anc_visits")
    private Integer numberOfAncVisits;

    @Column(name = "offline")
    private Boolean offline;

    @Column(name = "parity_at_booking")
    private Integer parityAtBooking;

    @Size(max = 255)
    @Column(name = "place_of_delivery")
    private String placeOfDelivery;

    @Column(name = "pregnant")
    private Boolean pregnant;

    @Size(max = 255)
    @Column(name = "prophylaxis")
    private String prophylaxis;

    @Size(max = 255)
    @Column(name = "rapid_reason_not_done")
    private String rapidReasonNotDone;

    @Size(max = 255)
    @Column(name = "rapid_test_for_recent_infection_done")
    private String rapidTestForRecentInfectionDone;

    @Size(max = 255)
    @Column(name = "received_blood_transfusion")
    private String receivedBloodTransfusion;

    @Size(max = 255)
    @Column(name = "received_medical_injections")
    private String receivedMedicalInjections;

    @Size(max = 255)
    @Column(name = "religion")
    private String religion;

    @Size(max = 255)
    @Column(name = "self_identified_gender")
    private String selfIdentifiedGender;

    @Size(max = 255)
    @Column(name = "sexually_active")
    private String sexuallyActive;

    @Column(name = "specify_gestation_atdelivery")
    private Integer specifyGestationAtdelivery;

    @Column(name = "submitted")
    private Boolean submitted;

    @Size(max = 255)
    @Column(name = "tattoed_with_unsterilised")
    private String tattoedWithUnsterilised;

    @Size(max = 255)
    @Column(name = "test_one_method")
    private String testOneMethod;

    @Size(max = 255)
    @Column(name = "test_one_result")
    private String testOneResult;

    @Size(max = 255)
    @Column(name = "test_three_method")
    private String testThreeMethod;

    @Size(max = 255)
    @Column(name = "test_three_result")
    private String testThreeResult;

    @Size(max = 255)
    @Column(name = "test_two_method")
    private String testTwoMethod;

    @Size(max = 255)
    @Column(name = "test_two_result")
    private String testTwoResult;

    @Column(name = "time")
    private LocalDate time;

    @Size(max = 255)
    @Column(name = "timing_of_hiv_diagnosis")
    private String timingOfHivDiagnosis;

    @Size(max = 255)
    @Column(name = "type_of_delivery")
    private String typeOfDelivery;

    @Size(max = 255)
    @Column(name = "unprotected_sex")
    private String unprotectedSex;

    @Size(max = 255)
    @Column(name = "victim_suspected_victim_of_sexual_abuse")
    private String victimSuspectedVictimOfSexualAbuse;

    @Size(max = 255)
    @Column(name = "who_clinical_stage_at_notification")
    private String whoClinicalStageAtNotification;

}