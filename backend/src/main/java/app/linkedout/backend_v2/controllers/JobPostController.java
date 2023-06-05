package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.JobPost;
import app.linkedout.backend_v2.models.JobPostAndCompany;
import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.services.JobPostService;
import app.linkedout.backend_v2.services.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/jobposts")
public class JobPostController {

    private final JobPostService jobPostService;
    private final SessionService sessionService;
    public JobPostController(JobPostService jobPostService, SessionService sessionService) {
        this.jobPostService = jobPostService;
        this.sessionService = sessionService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("")
    public List<JobPostAndCompany> getJobPosts() {
        return jobPostService.getJobPosts();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getMine")
    public ResponseEntity<List<JobPostAndCompany>> getMyJobPosts() throws Exception {
        int id = sessionService.getCurrentUserId();
        return ResponseEntity.ok().body(jobPostService.getMyJobPosts(id));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("")
    public void addJobPost(@RequestBody JobPost jobPost) throws Exception {
        int user_id = sessionService.getCurrentUserId();
        jobPostService.addJobPost(jobPost, user_id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{post_ID}")
    public void deleteJobPost(@PathVariable("post_ID") Integer post_ID) {
        jobPostService.deleteJobPostById(post_ID);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{post_ID}")
    public JobPostAndCompany getJobPostDetails(@PathVariable("post_ID") Integer post_ID) {
        return jobPostService.getJobPostDetails(post_ID);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/filtered")
    public List<JobPostAndCompany> getFilteredJobPosts(@RequestBody Map<String, String> filterParams) {
        String content = filterParams.get("content");
        String job_title = filterParams.get("job_title");
        String position = filterParams.get("position");
        String workplace = filterParams.get("workplace");
        String location = filterParams.get("location");
        return jobPostService.filterJobPosts(content, job_title, position, workplace, location);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/applied")
    public List<JobPostAndCompany> getAppliedJobs() throws Exception {
        int user_ID = sessionService.getCurrentUserId();
        return jobPostService.getAppliedJobs(user_ID);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{post_ID}")
    public void applyForJob(@PathVariable("post_ID") Integer post_ID) throws Exception {
        int user_ID = sessionService.getCurrentUserId();
        jobPostService.apply(user_ID, post_ID);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/applicants/{post_ID}")
    public List<Person> getApplicantsOfPost(@PathVariable("post_ID") Integer post_ID) {
        return jobPostService.getApplicantsOfPost(post_ID);
    }
}
