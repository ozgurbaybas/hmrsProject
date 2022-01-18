package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.Resume;

import java.util.List;

public interface ResumeDao extends JpaRepository <Resume, Integer> {

    List<Resume> findByCandidateId(int candidateId);

}
