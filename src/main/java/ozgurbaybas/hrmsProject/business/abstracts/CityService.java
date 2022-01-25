package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);
}
