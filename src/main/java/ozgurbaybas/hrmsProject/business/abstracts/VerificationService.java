package ozgurbaybas.hrmsProject.business.abstracts;

import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.User;

public interface VerificationService {
    Result add(User user);
    DataResult<Boolean> checkForEmail(String... emails);
    Result sendVerificationMail();
    Result verifiedUser();
}
