package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.Experience;
import app.linkedout.backend_v2.models.ExperienceAndCompany;
import app.linkedout.backend_v2.services.ExperienceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;
    ObjectMapper objectMapper = new ObjectMapper();

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{user_ID}")
    public List<ExperienceAndCompany> getExperiences(@PathVariable("user_ID") Integer user_ID) {
        return experienceService.getExperiences(user_ID);
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public void addExperience(@RequestBody Map<String, Object> requestMap) {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String companyName = (String) requestMap.get("companyName");
        experienceService.addExperience(experience, companyName);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("")
    public void editExperience(@RequestBody Map<String, Object> requestMap) {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String companyName = (String) requestMap.get("companyName");
        experienceService.editExperience(experience, companyName);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{exp_id}/{user_id}")
    public void deleteExperience(@PathVariable("exp_id") int exp_id,@PathVariable("user_id") int user_id) {
        experienceService.deleteExperience(exp_id, user_id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/educations/{user_ID}")
    public List<ExperienceAndCompany> getEducations(@PathVariable("user_ID") Integer user_ID) {
        return experienceService.getEducations(user_ID);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/educations")
    public void addEducation(@RequestBody Map<String, Object> requestMap) {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String institutionName = (String) requestMap.get("institutionName");
        experienceService.addEducation(experience, institutionName);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/educations")
    public void editEducation(@RequestBody Map<String, Object> requestMap) {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String institutionName = (String) requestMap.get("institutionName");
        experienceService.editEducation(experience, institutionName);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/educations/{exp_id}/{user_id}")
    public void deleteEducation(@PathVariable("exp_id") int exp_id,@PathVariable("user_id") int user_id) {
        experienceService.deleteEducation(exp_id, user_id);
    }
}
