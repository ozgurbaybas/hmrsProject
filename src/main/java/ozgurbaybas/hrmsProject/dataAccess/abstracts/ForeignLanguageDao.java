package ozgurbaybas.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ozgurbaybas.hrmsProject.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository <ForeignLanguage, Integer> {

}
