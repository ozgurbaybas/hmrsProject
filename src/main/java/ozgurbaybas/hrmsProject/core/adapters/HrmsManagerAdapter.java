package ozgurbaybas.hrmsProject.core.adapters;

import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.webServices.hrmsVerifications.HrmsVerificationManager;

@Service
public class HrmsManagerAdapter implements HrmsService {
    private HrmsVerificationManager hrmsVerificationManager = new HrmsVerificationManager();

    @Override
    public boolean checkForIdentityNumber(String identityNumber) {
        return this.hrmsVerificationManager.emptyCheckerForUser(identityNumber);
    }

}
