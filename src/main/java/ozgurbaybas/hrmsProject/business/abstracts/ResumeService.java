package ozgurbaybas.hrmsProject.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.Resume;

import java.util.List;

public interface ResumeService {
    Result add(Resume resume);
    DataResult<List<Resume>> findByResumeId(int id);
    DataResult<List<Resume>> getAll();
    Result addImage(int id, MultipartFile file);
}