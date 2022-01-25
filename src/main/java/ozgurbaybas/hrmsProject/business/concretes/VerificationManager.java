package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.VerificationService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.*;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.VerificationDao;
import ozgurbaybas.hrmsProject.entities.concretes.User;
import ozgurbaybas.hrmsProject.entities.concretes.Verification;

import java.util.Date;

@Service
public class VerificationManager implements VerificationService {
    private VerificationDao verificationDao;
    private Verification verification;

    @Autowired
    public VerificationManager(VerificationDao verificationDao) {
        this.verificationDao = verificationDao;
    }

    @Override
    public Result add(User user) {
        verification = new Verification();
        verification.setUserId(user.getId());
        verification.setConfirm(true);
        verification.setCreateDate(new Date());

        this.sendVerificationMail();
        this.verifiedUser();


        this.verificationDao.save(verification);
        System.out.println("Verification Process Done");
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<Boolean> checkForEmail(String... emails) {
        for (String email:emails){
            if(email.contains("@gmail") || email.contains("@hotmail") || email.contains("@outlook"))
                return new SuccessDataResult<Boolean>();
        }
        return new ErrorDataResult<Boolean>();
    }

    @Override
    public Result sendVerificationMail() {
        System.out.println("Please click on the link sent to your e-mail address for the verification process.");
        return new SuccessResult();
    }

    @Override
    public Result verifiedUser() {
        System.out.println("Verification Process Completed Successfully!");
        return new SuccessResult();
    }
}
