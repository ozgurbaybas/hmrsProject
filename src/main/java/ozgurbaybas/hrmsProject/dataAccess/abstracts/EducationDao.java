package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.Education;

import java.util.List;

public interface EducationDao extends JpaRepository <Education, Integer> {

    List<Education> findAllByOrderByGraduationDateAsc();
    List<Education> findAllByOrderByGraduationDateDesc();

}