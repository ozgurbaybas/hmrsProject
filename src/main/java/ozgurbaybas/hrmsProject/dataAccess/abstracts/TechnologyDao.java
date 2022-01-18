package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository <Technology, Integer> {

}
