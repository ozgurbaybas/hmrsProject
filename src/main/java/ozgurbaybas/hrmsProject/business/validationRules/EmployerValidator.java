package ozgurbaybas.hrmsProject.business.validationRules;

import ozgurbaybas.hrmsProject.entities.concretes.Employer;

public class EmployerValidator {
    public static boolean Validator(Employer employer){
        if(employer.getWebsite().isEmpty() || employer.getCompanyName().isEmpty() || employer.getPhone().isEmpty()){
            return false;
        }
        return true;
    }
}
