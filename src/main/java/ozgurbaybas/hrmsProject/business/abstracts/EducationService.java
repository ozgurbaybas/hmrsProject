package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    Result add(Education education);
    DataResult<List<Education>> getAll();
    DataResult<List<Education>> findAllByOrderByGraduationDateAsc();
    DataResult<List<Education>> findAllByOrderByGraduationDateDesc();
}