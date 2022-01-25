package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.TypeOfWorkService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.TypeOfWorkDao;
import ozgurbaybas.hrmsProject.entities.concretes.TypeOfWork;

import java.util.List;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {
    private TypeOfWorkDao typeOfWorkDao;

    @Autowired
    public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
        this.typeOfWorkDao = typeOfWorkDao;
    }

    @Override
    public Result add(TypeOfWork typeOfWork) {
        this.typeOfWorkDao.save(typeOfWork);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<TypeOfWork>> getAll() {
        return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<TypeOfWork> getById(int id) {
        return new SuccessDataResult<TypeOfWork>(this.typeOfWorkDao.getOne(id),Messages.Listed);
    }
}