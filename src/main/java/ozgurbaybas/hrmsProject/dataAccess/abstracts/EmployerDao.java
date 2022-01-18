package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ozgurbaybas.hrmsProject.entities.concretes.Employer;

import java.util.List;

@Repository
public interface EmployerDao extends JpaRepository <Employer, Integer> {

    List<Employer> findByEmail(String email);

}
