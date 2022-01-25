package ozgurbaybas.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ozgurbaybas.hrmsProject.business.abstracts.TypeOfWorkService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.entities.concretes.TypeOfWork;

import java.util.List;

@RestController
@RequestMapping("/api/typeOfWorks")
@CrossOrigin
public class TypeOfWorksController {
    private TypeOfWorkService typeOfWorkService;

    @Autowired
    public TypeOfWorksController(TypeOfWorkService typeOfWorkService) {
        this.typeOfWorkService = typeOfWorkService;
    }

    @GetMapping("/getAll")
    public DataResult<List<TypeOfWork>> getAll(){
        return this.typeOfWorkService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<TypeOfWork> getById(int id){
        return this.typeOfWorkService.getById(id);
    }
}