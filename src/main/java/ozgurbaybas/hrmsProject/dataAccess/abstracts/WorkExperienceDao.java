package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository <WorkExperience, Integer> {

    List<WorkExperience> findAllByOrderByEndDateDesc();

}
