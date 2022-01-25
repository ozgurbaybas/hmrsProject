package ozgurbaybas.hrmsProject.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.EmployerService;
import ozgurbaybas.hrmsProject.business.abstracts.EmployerVerificationService;
import ozgurbaybas.hrmsProject.business.abstracts.UserService;
import ozgurbaybas.hrmsProject.business.abstracts.VerificationService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.business.validationRules.EmployerValidator;
import ozgurbaybas.hrmsProject.business.validationRules.UserValidator;
import ozgurbaybas.hrmsProject.core.utilities.business.BusinessRules;
import ozgurbaybas.hrmsProject.core.utilities.business.ValidationTool;
import ozgurbaybas.hrmsProject.core.utilities.results.*;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.EmployerDao;
import ozgurbaybas.hrmsProject.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private UserService userService;
    private VerificationService verificationService;
    private EmployerVerificationService employerVerificationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService, VerificationService verificationService,EmployerVerificationService employerVerificationService) {
        this.employerDao = employerDao;
        this.userService = userService;
        this.verificationService = verificationService;
        this.employerVerificationService = employerVerificationService;
    }

    @Override
    public Result add(Employer employer) {
        var validator = ValidationTool.run(EmployerValidator.Validator(employer), UserValidator.Validator(employer));
        var result = BusinessRules.run(checkForEmail(employer.getEmail()));
        var verification = this.verificationService.checkForEmail(employer.getEmail()).isSuccess();

        if(validator){
            if(result !=null){
                System.out.println(Messages.CannotRepeat);
                return new ErrorResult(Messages.CannotRepeat);
            }

            if(!verification){
                var saveEmployer = this.employerDao.save(employer);
                this.userService.register(saveEmployer);
                this.verificationService.add(saveEmployer);
                this.employerVerificationService.add(employer);

                System.out.println("Company: "+employer.getCompanyName() + " " + Messages.Successful);
                return new SuccessResult(Messages.Successful);
            }
            System.out.println(Messages.RegistrationError);
            return new ErrorResult(Messages.RegistrationError);
        }
        System.out.println(Messages.Required);
        return new ErrorResult(Messages.Required);
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<List<Employer>> findByEmployerEmail(String email) {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findByEmail(email),Messages.Listed);
    }

    private Result checkForEmail(String email){
        var result = this.employerDao.findByEmail(email);

        if(result.size()!=0)
            return new ErrorResult();

        return new SuccessResult();
    }
}