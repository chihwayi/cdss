package zw.org.mohcc.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.org.mohcc.cdss.model.entity.InvestigationRegister;

public interface InvestigationRegisterRepository extends JpaRepository<InvestigationRegister, String> {

}
