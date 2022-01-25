package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.ForeignLanguageService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.ForeignLanguageDao;
import ozgurbaybas.hrmsProject.entities.concretes.ForeignLanguage;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(),Messages.Listed);
    }
}
