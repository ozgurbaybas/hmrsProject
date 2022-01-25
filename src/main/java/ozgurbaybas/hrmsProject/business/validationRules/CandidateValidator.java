package ozgurbaybas.hrmsProject.business.validationRules;

import ozgurbaybas.hrmsProject.entities.concretes.Candidate;

public class CandidateValidator {
    public static boolean Validator(Candidate candidate) {
        if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() || candidate.getIdentityNumber().isEmpty() || candidate.getYearOfBirth()==null){
            return false;
        }
        return true;
    }
}