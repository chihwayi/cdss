package zw.org.mohcc.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.org.mohcc.cdss.model.entity.PatientRegister;

@Repository
public interface PatientRegisterRepository extends JpaRepository<PatientRegister, String> {
}
