package ozgurbaybas.hrmsProject.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ozgurbaybas.hrmsProject.business.abstracts.UserService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.entities.concretes.User;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }
}
