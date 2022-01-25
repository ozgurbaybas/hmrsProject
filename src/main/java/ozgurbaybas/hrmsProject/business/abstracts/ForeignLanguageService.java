package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    Result add(ForeignLanguage foreignLanguage);
    DataResult<List<ForeignLanguage>> getAll();
}
