package ozgurbaybas.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ozgurbaybas.hrmsProject.business.abstracts.ResumeService;
import ozgurbaybas.hrmsProject.core.utilities.results.DataResult;
import ozgurbaybas.hrmsProject.core.utilities.results.Result;
import ozgurbaybas.hrmsProject.entities.concretes.Resume;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin
public class ResumesController {
    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Resume resume){
        return this.resumeService.add(resume);
    }

    @GetMapping("/findByCandidateId")
    public DataResult<List<Resume>> findByCandidateId(@RequestParam int id){
        return this.resumeService.findByResumeId(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Resume>> getAll() {
        return this.resumeService.getAll();
    }

    @PostMapping("/addImage")
    public Result addImage(@RequestParam int id,@RequestPart MultipartFile file){
        return this.resumeService.addImage(id,file);
    }
}
