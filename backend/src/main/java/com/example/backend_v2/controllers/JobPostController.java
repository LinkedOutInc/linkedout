package com.example.backend_v2.controllers;

import com.example.backend_v2.models.JobPost;
import com.example.backend_v2.models.JobPostAndCompany;
import com.example.backend_v2.services.JobPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public void deleteJobPost(@PathVariable("id") Integer id) {
        jobPostService.deleteJobPostById(id);
    }

    @GetMapping("/{id}")
    public JobPostAndCompany getJobPostDetails(@PathVariable("id") Integer id) {
        return jobPostService.getJobPostDetails(id);
    }

    @GetMapping("/filtered")
    public List<JobPostAndCompany> getFilteredJobPosts(String content, String job_title, String position, String workplace, String location) {
        return jobPostService.filterJobPosts(content, job_title, position, workplace, location);
    }

    @GetMapping("/applied/{id}")
    public List<JobPostAndCompany> getAppliedJobs(@PathVariable("id") Integer id) {
        return jobPostService.getAppliedJobs(id);
    }

    @PostMapping("{user_id}/{post_id}")
    public void applyForJob(@PathVariable("user_id") Integer user_id,@PathVariable("post_id") Integer post_id) {
        jobPostService.apply(user_id, post_id);
    }
}
