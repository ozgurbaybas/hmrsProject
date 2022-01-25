package ozgurbaybas.hrmsProject.core.adapters;

import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.entities.concretes.Candidate;
import ozgurbaybas.hrmsProject.webServices.mernisService.VJIKPSPublicSoap;

import java.util.Locale;

@Service
public class MernisManagerAdapter implements MernisService {
    private VJIKPSPublicSoap vjikpsPublicSoap = new VJIKPSPublicSoap();

    @Override
    public boolean checkForCandidate(Candidate candidate) {
        try{
            return this.vjikpsPublicSoap.TCKimlikNoDogrula(
                    Long.valueOf(candidate.getIdentityNumber()),
                    candidate.getFirstName().toUpperCase(Locale.ROOT),
                    candidate.getLastName().toUpperCase(Locale.ROOT),
                    candidate.getYearOfBirth().getYear());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}