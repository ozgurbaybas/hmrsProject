package ozgurbaybas.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgurbaybas.hrmsProject.business.abstracts.WorkExperienceService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.WorkExperience;

import java.util.List;

@RestController
@RequestMapping("api/workexperiences")
@CrossOrigin
public class WorkExperiencesController {
    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkExperience>> getAll(){
        return this.workExperienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkExperience workExperience){
        return this.workExperienceService.add(workExperience);
    }

    @GetMapping("/findAllByOrderByEndDateDesc")
    public DataResult<List<WorkExperience>> findAllByOrderByEndDateDesc(){
        return this.workExperienceService.findAllByOrderByEndDateDesc();
    }
}