package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.AdminCounts;
import app.linkedout.backend_v2.models.Hiring;
import app.linkedout.backend_v2.models.RoleCount;
import app.linkedout.backend_v2.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    private final AdminService adminService;
    private final HiringReportService hiringReportService;
    private final PersonService personService;
    private final RecruiterService recruiterService;
    private final CareerExpertService careerExpertService;
    private final JobPostService jobPostService;

    public AdminController(AdminService adminService, HiringReportService hiringReportService, PersonService personService, RecruiterService recruiterService, CareerExpertService careerExpertService, JobPostService jobPostService) {
        this.adminService = adminService;
        this.hiringReportService = hiringReportService;
        this.personService = personService;
        this.recruiterService = recruiterService;
        this.careerExpertService = careerExpertService;
        this.jobPostService = jobPostService;
    }

    @GetMapping("/generateRoleCountReport")
    public ResponseEntity<List<RoleCount>> generateRoleCountReport() {
        return ResponseEntity.ok().body(adminService.generateReport());
    }

    @GetMapping("/generateHiringReport")
    public ResponseEntity<List<Hiring>> generateHiringReport() {
        return ResponseEntity.ok().body(hiringReportService.generateReport());
    }

    @GetMapping("/getCounts")
    public ResponseEntity<AdminCounts> getCounts() {

        AdminCounts adminCounts = new AdminCounts(personService.getPersons().size(), recruiterService.getRecruiters().size(), careerExpertService.getCareerExperts().size(),
                jobPostService.getJobPosts().size(), jobPostService.getJobPosts().size(), 0, jobPostService.getApplicationCount());
        return ResponseEntity.ok().body(adminCounts);
    }
}
