package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.EmployerVerificationService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.EmployerVerificationDao;
import ozgurbaybas.hrmsProject.entities.concretes.Employer;
import ozgurbaybas.hrmsProject.entities.concretes.EmployerVerification;

import java.util.Date;

@Service
public class EmployerVerificationManager implements EmployerVerificationService {
    private EmployerVerificationDao employerVerificationDao;
    private EmployerVerification verification;

    @Autowired
    public EmployerVerificationManager(EmployerVerificationDao employerVerificationDao) {
        this.employerVerificationDao = employerVerificationDao;
    }

    @Override
    public Result add(Employer employer) {
        this.verification = new EmployerVerification();
        this.verification.setEmployerId(employer.getId());
        this.verification.setConfirm(true);
        this.verification.setCreateDate(new Date());

        this.employerVerificationDao.save(this.verification);
        System.out.println("Verification Request Sent to Employer.");
        return new SuccessResult(Messages.Added);
    }
}