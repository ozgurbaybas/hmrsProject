package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.WorkExperienceService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.WorkExperienceDao;
import ozgurbaybas.hrmsProject.entities.concretes.WorkExperience;

import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {
    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public Result add(WorkExperience workExperience) {
        this.workExperienceDao.save(workExperience);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<WorkExperience>> findAllByOrderByEndDateDesc() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAllByOrderByEndDateDesc(),Messages.Listed);
    }

    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(), Messages.Listed);
    }
}
