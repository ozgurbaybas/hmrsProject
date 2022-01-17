package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.User;

import java.util.List;

public interface UserService { Result register(User user);

    DataResult<List<User>> getAll();
}
