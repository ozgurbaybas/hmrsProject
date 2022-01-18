package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.TypeOfWork;

public interface TypeOfWorkDao extends JpaRepository <TypeOfWork, Integer> {



}
