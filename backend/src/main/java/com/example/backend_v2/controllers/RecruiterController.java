package com.example.backend_v2.controllers;

import com.example.backend_v2.models.Recruiter;
import com.example.backend_v2.services.RecruiterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recruiters")
public class RecruiterController {

    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @GetMapping
    public List<Recruiter> getRecruiters() {
        return recruiterService.getRecruiters();
    }

    @GetMapping("{id}")
    public Recruiter getRecruiterById(@PathVariable("id") Integer id) {
        return recruiterService.getRecruiterById(id);
    }

    @PostMapping
    public void addRecruiter(@RequestBody Recruiter recruiter) {
        recruiterService.addRecruiter(recruiter);
    }

    @DeleteMapping("{id}")
    public void deleteRecruiter(@PathVariable Integer id) {
        recruiterService.deleteRecruiterById(id);
    }
}
