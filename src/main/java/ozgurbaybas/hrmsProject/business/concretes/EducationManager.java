package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.EducationService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.EducationDao;
import ozgurbaybas.hrmsProject.entities.concretes.Education;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<List<Education>> findAllByOrderByGraduationDateAsc() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAllByOrderByGraduationDateAsc(), Messages.Listed);
    }

    @Override
    public DataResult<List<Education>> findAllByOrderByGraduationDateDesc() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAllByOrderByGraduationDateDesc(), Messages.Listed);
    }
}