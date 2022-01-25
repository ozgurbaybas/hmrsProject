package ozgurbaybas.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ozgurbaybas.hrmsProject.business.abstracts.JobAdvertisementService;
import ozgurbaybas.hrmsProject.business.constants.Messages;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessDataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.SuccessResult;
import ozgurbaybas.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import ozgurbaybas.hrmsProject.entities.concretes.JobAdvertisement;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.Added);
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {

        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.Updated);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrue(), Messages.Listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndCreateDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByCreateDateAsc(), Messages.Listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByCreateDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByCreateDateDesc(), Messages.Listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployer(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueAndEmployerId(employerId), Messages.Listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), Messages.Listed);
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id),Messages.Listed);
    }

}