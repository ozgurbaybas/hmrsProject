package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository <JobAdvertisement, Integer> {

    List<JobAdvertisement> findByActiveTrueOrderByCreateDateAsc();
    List<JobAdvertisement> findByActiveTrueOrderByCreateDateDesc();
    List<JobAdvertisement> findByActiveTrue();
    List<JobAdvertisement> findByActiveTrueAndEmployerId(int employerId);
    JobAdvertisement findById(int id);

}
