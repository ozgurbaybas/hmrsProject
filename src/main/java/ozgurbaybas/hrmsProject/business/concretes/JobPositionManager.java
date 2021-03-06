package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.JobPositionService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.business.BusinessRules;
import ozgurbaybas.hrmsProject.core.utilities.results.*;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.JobPositionDao;
import ozgurbaybas.hrmsProject.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), Messages.Listed);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = BusinessRules.run(checkForUserExist(jobPosition.getName()));

        if (result != null) {
            System.out.println(Messages.JobPositionCannotRepeat);
            return new ErrorResult(Messages.JobPositionCannotRepeat);
        }

        this.jobPositionDao.save(jobPosition);
        System.out.println("İş Pozisyonu Eklendi: " + jobPosition.getName());
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<JobPosition>> findByJobPositionName(String jobPositionName) {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findByName(jobPositionName),Messages.Listed);
    }

    private Result checkForUserExist(String jobPositionName){
        var result = this.jobPositionDao.findByName(jobPositionName);

        if (result.size()!=0)
            return new ErrorResult();

        return new SuccessResult();
    }
}
