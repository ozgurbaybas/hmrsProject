package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ozgurbaybas.hrmsProject.entities.concretes.JobPosition;

import java.util.List;

@Repository
public interface JobPositionDao extends JpaRepository <JobPosition, Integer> {
    List<JobPosition> findByName(String jobPositionName);
}
