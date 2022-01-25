package ozgurbaybas.hrmsProject.business.abstracts;


import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.TypeOfWork;

import java.util.List;

public interface TypeOfWorkService {
    Result add(TypeOfWork typeOfWork);
    DataResult<List<TypeOfWork>> getAll();
    DataResult<TypeOfWork> getById(int id);
}