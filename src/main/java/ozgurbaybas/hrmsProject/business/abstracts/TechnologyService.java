package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.Technology;

import java.util.List;

public interface TechnologyService {
    Result add(Technology technology);
    DataResult<List<Technology>> getAll();
}