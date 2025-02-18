package zw.org.mohcc.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zw.org.mohcc.cdss.model.entity.ArtRegister;

import java.util.List;

@Repository
public interface ArtRegisterRepository extends JpaRepository<ArtRegister, String> {

    @Query("SELECT ar.artId, ar.siteId, ar.artNumber, ar.birthDate, ar.dateEnrolled, ar.dateOfHivTest, ar.personId, ar.sex, " +
            "acr.artStatusId, acr.adverseEventStatus, acr.date, acr.reason, acr.reasonForRegimenSubstitution, acr.regimen, acr.regimenFrom, acr.regimenLineFromName, acr.regimenLineName, acr.state, acr.treatmentFailureReason, " +
            "vli.laboratoryInvestigationId, vli.date, vli.note, vli.result, vli.resultDate, vli.resultIssued, vli.test, " +
            "ir.laboratoryInvestigationId, ir.date, ir.dateResultIssued, ir.investigationType, ir.note, ir.result, ir.resultDate, ir.resultIssued " +
            "FROM ArtRegister ar " +
            "LEFT JOIN ArtCurrentStatusRegister acr ON acr.artRegister.artId = ar.artId " +
            "LEFT JOIN ViralLoadInvestigationRegister vli ON vli.personId = ar.personId " +
            "LEFT JOIN InvestigationRegister ir ON ir.personId = ar.personId " +
            "WHERE ar.personId = :personId " +
            "ORDER BY acr.date, vli.date, ir.date")
    List<Object[]> findArtRegisterByPersonId(String personId);

}
