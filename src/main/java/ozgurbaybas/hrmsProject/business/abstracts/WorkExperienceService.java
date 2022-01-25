package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceService {
    Result add(WorkExperience workExperience);
    DataResult<List<WorkExperience>> findAllByOrderByEndDateDesc();
    DataResult<List<WorkExperience>> getAll();
}
