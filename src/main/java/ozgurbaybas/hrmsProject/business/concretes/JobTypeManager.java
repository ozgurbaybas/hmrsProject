package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.JobTypeService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.JobTypeDao;
import ozgurbaybas.hrmsProject.entities.concretes.JobType;

import java.util.List;

@Service
public class JobTypeManager implements JobTypeService {
    private JobTypeDao jobTypeDao;

    @Autowired
    public JobTypeManager(JobTypeDao jobTypeDao) {
        this.jobTypeDao = jobTypeDao;
    }

    @Override
    public Result add(JobType jobType) {
        this.jobTypeDao.save(jobType);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<JobType>> getAll() {
        return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<JobType> getById(int id) {
        return new SuccessDataResult<JobType>(this.jobTypeDao.getOne(id),Messages.Listed);
    }
}
