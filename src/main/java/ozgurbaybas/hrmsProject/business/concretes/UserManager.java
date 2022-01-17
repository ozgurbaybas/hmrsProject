package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.UserService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.UserDao;
import ozgurbaybas.hrmsProject.entities.concretes.User;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result register(User user) {
        this.userDao.save(user);
        return new SuccessResult("Registration Successful");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Listed");
    }
}
