package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.JobPost;
import app.linkedout.backend_v2.models.JobPostAndCompany;
import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.services.JobPostService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/jobposts")
public class JobPostController {

    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("")
    public List<JobPostAndCompany> getJobPosts() {
        return jobPostService.getJobPosts();
    }

    @PostMapping("")
    public void addJobPost(@RequestBody JobPost jobPost) {
        jobPostService.addJobPost(jobPost);
    }

    @DeleteMapping("/{post_ID}")
    public void deleteJobPost(@PathVariable("post_ID") Integer post_ID) {
        jobPostService.deleteJobPostById(post_ID);
    }

    @GetMapping("/{post_ID}")
    public JobPostAndCompany getJobPostDetails(@PathVariable("post_ID") Integer post_ID) {
        return jobPostService.getJobPostDetails(post_ID);
    }

    @PostMapping("/filtered")
    public List<JobPostAndCompany> getFilteredJobPosts(@RequestBody Map<String, String> filterParams) {
        String content = filterParams.get("content");
        String job_title = filterParams.get("job_title");
        String position = filterParams.get("position");
        String workplace = filterParams.get("workplace");
        String location = filterParams.get("location");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_date, end_date;
        try {
            start_date = new Date(dateFormat.parse(filterParams.get("start_date")).getTime());
            end_date = new Date(dateFormat.parse(filterParams.get("end_date")).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jobPostService.filterJobPosts(content, job_title, position, workplace, location, start_date, end_date);
    }

    @GetMapping("/applied/{user_ID}")
    public List<JobPostAndCompany> getAppliedJobs(@PathVariable("user_ID") Integer user_ID) {
        return jobPostService.getAppliedJobs(user_ID);
    }

    @PostMapping("{user_ID}/{post_ID}")
    public void applyForJob(@PathVariable("user_ID") Integer user_ID,@PathVariable("post_ID") Integer post_ID) {
        jobPostService.apply(user_ID, post_ID);
    }

    @GetMapping("/applicants/{post_ID}")
    public List<Person> getApplicantsOfPost(@PathVariable("post_ID") Integer post_ID) {
        return jobPostService.getApplicantsOfPost(post_ID);
    }
}
