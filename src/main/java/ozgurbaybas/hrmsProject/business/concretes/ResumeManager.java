package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ozgurbaybas.hrmsProject.business.abstracts.ResumeService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.helpers.ImageService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.ResumeDao;
import ozgurbaybas.hrmsProject.entities.concretes.Resume;

import java.util.List;
import java.util.Map;

@Service
public class ResumeManager implements ResumeService {
    private ResumeDao resumeDao;
    private ImageService imageService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,ImageService imageService) {
        this.resumeDao = resumeDao;
        this.imageService = imageService;
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public DataResult<List<Resume>> findByResumeId(int id) {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findByCandidateId(id),Messages.Listed);
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),Messages.Listed);
    }

    @Override
    public Result addImage(int id, MultipartFile file) {
        Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        Resume resume = this.resumeDao.getOne(id);
        resume.setImageUrl(result.get("url"));
        this.resumeDao.save(resume);
        return new SuccessResult("Başarıyla eklendi");
    }
}