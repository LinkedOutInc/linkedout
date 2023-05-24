package com.example.backend_v2.controllers;

import com.example.backend_v2.models.Experience;
import com.example.backend_v2.services.ExperienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("")
    public List<Experience> getExperiences(int user_id) {
        return experienceService.getExperiences(user_id);
    }
    @PostMapping("")
    public void addExperience(Experience experience, String companyName) {
        experienceService.addExperience(experience, companyName);
    }
    @PutMapping("")
    public void editExperience(Experience experience, String companyName) {
        experienceService.editExperience(experience, companyName);
    }

    @DeleteMapping("/{exp_id}/{user_id}")
    public void deleteExperience(@PathVariable("exp_id") int exp_id,@PathVariable("user_id") int user_id) {
        experienceService.deleteExperience(exp_id, user_id);
    }
    @GetMapping("/educations")
    public List<Experience> getEducations(int user_id) {
        return experienceService.getEducations(user_id);
    }
    @PostMapping("/educations")
    public void addEducation(Experience experience, String companyName) {
        experienceService.addEducation(experience, companyName);
    }
    @PutMapping("/educations")
    public void editEducation(Experience experience, String companyName) {
        experienceService.editEducation(experience, companyName);
    }
    @DeleteMapping("/educations/{exp_id}/{user_id}")
    public void deleteEducation(@PathVariable("exp_id") int exp_id,@PathVariable("user_id") int user_id) {
        experienceService.deleteEducation(exp_id, user_id);
    }
}
