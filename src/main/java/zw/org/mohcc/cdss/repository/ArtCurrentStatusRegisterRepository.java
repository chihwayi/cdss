package zw.org.mohcc.cdss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.org.mohcc.cdss.model.entity.ArtCurrentStatusRegister;

@Repository
public interface ArtCurrentStatusRegisterRepository extends JpaRepository<ArtCurrentStatusRegister, String> {

}
