package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.SystemEmployee;

public interface SystemEmployeeDao extends JpaRepository <SystemEmployee, Integer> {



}
