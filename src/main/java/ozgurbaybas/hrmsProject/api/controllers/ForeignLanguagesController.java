package ozgurbaybas.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ozgurbaybas.hrmsProject.business.abstracts.ForeignLanguageService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.ForeignLanguage;

import java.util.List;

@RestController
@RequestMapping("api/foreignlanguages")
@CrossOrigin
public class ForeignLanguagesController {
    private ForeignLanguageService foreignLanguageService;

    @GetMapping("/getAll")
    public DataResult<List<ForeignLanguage>> getAll(){
        return this.foreignLanguageService.getAll();
    }

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ForeignLanguage foreignLanguage){
        return this.foreignLanguageService.add(foreignLanguage);
    }
}
