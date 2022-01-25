package ozgurbaybas.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgurbaybas.hrmsProject.business.abstracts.TechnologyService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.Technology;

import java.util.List;

@RestController
@RequestMapping("api/technologies")
@CrossOrigin
public class TechnologiesController {
    private TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Technology>> getAll(){
        return this.technologyService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Technology technology){
        return this.technologyService.add(technology);
    }
}