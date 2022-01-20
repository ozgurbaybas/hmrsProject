package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
    DataResult<List<JobPosition>> findByJobPositionName(String jobPositionName);

}
