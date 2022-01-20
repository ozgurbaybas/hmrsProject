package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.JobType;

import java.util.List;

public interface JobTypeService {

    Result add(JobType jobType);
    DataResult<List<JobType>> getAll();
    DataResult<JobType> getById(int id);

}