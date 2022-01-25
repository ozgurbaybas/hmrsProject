package ozgurbaybas.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgurbaybas.hrmsProject.business.abstracts.EducationService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.Education;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("getAll")
    public Result getAll(){
        return this.educationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @GetMapping("/findAllByOrderByGraduationDateAsc")
    public DataResult<List<Education>> findAllByOrderByGraduationDateAsc(){
        return this.educationService.findAllByOrderByGraduationDateAsc();
    }

    @GetMapping("/findAllByOrderByGraduationDateDesc")
    public DataResult<List<Education>> findAllByOrderByGraduationDateDesc(){
        return this.educationService.findAllByOrderByGraduationDateDesc();
    }
}
