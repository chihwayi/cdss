package zw.org.mohcc.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.org.mohcc.cdss.model.entity.TbVisitRegister;

@Repository
public interface TbVisitRegisterRepository extends JpaRepository<TbVisitRegister, String> {
}
