package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.TechnologyService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.TechnologyDao;
import ozgurbaybas.hrmsProject.entities.concretes.Technology;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }

    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), Messages.Listed);
    }

    @Override
    public Result add(Technology technology) {
        this.technologyDao.save(technology);
        return new SuccessResult(Messages.Added);
    }
}