package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.services.RecruiterService;
import app.linkedout.backend_v2.models.Recruiter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recruiters")
public class RecruiterController {

    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Recruiter> getRecruiters() {
        return recruiterService.getRecruiters();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{id}")
    public Recruiter getRecruiterById(@PathVariable("id") Integer id) throws Exception {
        return recruiterService.getRecruiterById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void addRecruiter(@RequestBody Recruiter recruiter) {
        recruiterService.addRecruiter(recruiter);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("{id}")
    public void deleteRecruiter(@PathVariable Integer id) {
        recruiterService.deleteRecruiterById(id);
    }
}
