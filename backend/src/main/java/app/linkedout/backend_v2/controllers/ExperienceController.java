package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.Experience;
import app.linkedout.backend_v2.models.ExperienceAndCompany;
import app.linkedout.backend_v2.services.ExperienceService;
import app.linkedout.backend_v2.services.SessionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;
    private final SessionService sessionService;
    ObjectMapper objectMapper = new ObjectMapper();

    public ExperienceController(ExperienceService experienceService, SessionService sessionService) {
        this.experienceService = experienceService;
        this.sessionService = sessionService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<ExperienceAndCompany> getExperiences() throws Exception {
        int user_ID = sessionService.getCurrentUserId();
        return experienceService.getExperiences(user_ID);
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public void addExperience(@RequestBody Map<String, Object> requestMap) throws Exception {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String companyName = (String) requestMap.get("companyName");
        int user_ID = sessionService.getCurrentUserId();
        experienceService.addExperience(experience, companyName, user_ID);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("")
    public void editExperience(@RequestBody Map<String, Object> requestMap) throws Exception {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String companyName = (String) requestMap.get("companyName");
        int user_ID = sessionService.getCurrentUserId();
        experienceService.editExperience(experience, companyName, user_ID);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{exp_id}")
    public void deleteExperience(@PathVariable("exp_id") int exp_id) throws Exception {
        int user_id = sessionService.getCurrentUserId();
        experienceService.deleteExperience(exp_id, user_id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/educations")
    public List<ExperienceAndCompany> getEducations() throws Exception {
        int user_ID = sessionService.getCurrentUserId();
        return experienceService.getEducations(user_ID);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/educations")
    public void addEducation(@RequestBody Map<String, Object> requestMap) throws Exception {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String institutionName = (String) requestMap.get("institutionName");
        int user_ID = sessionService.getCurrentUserId();
        experienceService.addEducation(experience, institutionName, user_ID);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/educations")
    public void editEducation(@RequestBody Map<String, Object> requestMap) throws Exception {
        Experience experience = objectMapper.convertValue(requestMap.get("experience"), Experience.class);
        String institutionName = (String) requestMap.get("institutionName");
        int user_ID = sessionService.getCurrentUserId();
        experienceService.editEducation(experience, institutionName, user_ID);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/educations/{exp_id}")
    public void deleteEducation(@PathVariable("exp_id") int exp_id) throws Exception {
        int user_id = sessionService.getCurrentUserId();
        experienceService.deleteEducation(exp_id, user_id);
    }
}
