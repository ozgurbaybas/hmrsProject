package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<JobAdvertisement> getById(int id);
    DataResult<List<JobAdvertisement>> findByActiveTrue();
    DataResult<List<JobAdvertisement>> findByActiveTrueAndCreateDateAsc();
    DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateDesc();
    DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployer(int employerId);
}