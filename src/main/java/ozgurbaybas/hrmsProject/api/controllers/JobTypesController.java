package ozgurbaybas.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ozgurbaybas.hrmsProject.business.abstracts.JobTypeService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.entities.concretes.JobType;

import java.util.List;

@RestController
@RequestMapping("/api/jobTypes")
@CrossOrigin
public class JobTypesController {
    private JobTypeService jobTypeService;

    @Autowired
    public JobTypesController(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobType>> getAll(){
        return this.jobTypeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobType> getById(int id){
        return this.jobTypeService.getById(id);
    }

}
