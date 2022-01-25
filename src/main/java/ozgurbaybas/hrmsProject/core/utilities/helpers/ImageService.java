package ozgurbaybas.hrmsProject.core.utilities.helpers;

import org.springframework.web.multipart.MultipartFile;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;

public interface ImageService {
    DataResult<?> save(MultipartFile file);
}