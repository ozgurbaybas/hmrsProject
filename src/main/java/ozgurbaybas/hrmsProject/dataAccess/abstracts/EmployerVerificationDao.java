package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.EmployerVerification;

public interface EmployerVerificationDao extends JpaRepository <EmployerVerification, Integer> {

}