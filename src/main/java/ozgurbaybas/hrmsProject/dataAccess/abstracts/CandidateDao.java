package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ozgurbaybas.hrmsProject.entities.concretes.Candidate;

import java.util.List;

@Repository
public interface CandidateDao extends JpaRepository <Candidate, Integer> {
    List<Candidate> findByEmail (String email);
    List<Candidate> findByIdentityNumber (String identityNumber);
}