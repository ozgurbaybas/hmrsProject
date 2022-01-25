package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.CandidateService;
import ozgurbaybas.hrmsProject.business.abstracts.UserService;
import ozgurbaybas.hrmsProject.business.abstracts.VerificationService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.business.validationRules.CandidateValidator;
import ozgurbaybas.hrmsProject.business.validationRules.UserValidator;
import ozgurbaybas.hrmsProject.core.adapters.HrmsService;
import ozgurbaybas.hrmsProject.core.adapters.MernisService;
import ozgurbaybas.hrmsProject.core.utilities.business.BusinessRules;
import ozgurbaybas.hrmsProject.core.utilities.business.ValidationTool;
import ozgurbaybas.hrmsProject.core.utilities.results.*;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.CandidateDao;
import ozgurbaybas.hrmsProject.entities.concretes.Candidate;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserService userService;
    private VerificationService verificationService;
    private HrmsService hrmsService;
    private MernisService mernisService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService, VerificationService verificationService,HrmsService hrmsService/*,MernisService mernisService*/) {
        this.candidateDao = candidateDao;
        this.userService = userService;
        this.verificationService = verificationService;
        this.hrmsService = hrmsService;
        this.mernisService = mernisService;
    }

    @Override
    public Result add(Candidate candidate) {
        var validator = ValidationTool.run(CandidateValidator.Validator(candidate), UserValidator.Validator(candidate));
        var result = BusinessRules.run(checkForEmailExists(candidate.getEmail()),checkForIdentityNumberExists(candidate.getIdentityNumber()));
        var verification = this.verificationService.checkForEmail(candidate.getEmail()).isSuccess();

        if(validator){
            if(result !=null){
                System.out.println(Messages.CannotRepeat);
                return new ErrorResult(Messages.CannotRepeat);
            }

            if(verification){
                //Fake:this.hrmsService.checkForIdentityNumber(candidate.getIdentityNumber())
                if(this.mernisService.checkForCandidate(candidate)){
                    var saveCandidate = this.candidateDao.save(candidate);
                    this.userService.register(saveCandidate);
                    this.verificationService.add(saveCandidate);
                    System.out.println("Member: "+candidate.getFirstName() + " " +candidate.getLastName() + " " + Messages.Successful);
                    return new SuccessResult(Messages.Successful);
                }
                System.out.println(Messages.IdentityNumberFailed);
                return new ErrorResult(Messages.IdentityNumberFailed);
            }
            System.out.println(Messages.RegistrationError);
            return new ErrorResult(Messages.RegistrationError);
        }
        System.out.println(Messages.Required);
        return new ErrorResult(Messages.Required);
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),Messages.Listed);
    }

    @Override
    public DataResult<List<Candidate>> findByEmployerEmail(String email) {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByEmail(email),Messages.Listed);
    }

    @Override
    public DataResult<List<Candidate>> findByEmployerIdentityNumber(String identityNumber) {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByIdentityNumber(identityNumber),Messages.Listed);
    }


    private Result checkForEmailExists(String email){
        var result = this.candidateDao.findByEmail(email);

        if(result.size()!=0)
            return new ErrorResult();

        return new SuccessResult();
    }

    private Result checkForIdentityNumberExists(String identityNumber){
        var result = this.candidateDao.findByIdentityNumber(identityNumber);

        if(result.size()!=0)
            return new ErrorResult();

        return new SuccessResult();
    }
}