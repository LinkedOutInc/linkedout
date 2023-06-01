package com.example.backend_v2.services;

import com.example.backend_v2.dao.JobPostDao;
import com.example.backend_v2.models.CareerExpert;
import com.example.backend_v2.models.JobPost;
import com.example.backend_v2.models.JobPostAndCompany;
import jakarta.el.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {

    private final JobPostDao jobPostDao;

    public JobPostService(JobPostDao jobPostDao) {
        this.jobPostDao = jobPostDao;
    }

    public List<JobPostAndCompany> getJobPosts() {
        return jobPostDao.getJobs();
    }

    public void addJobPost(JobPost jobPost) {
        jobPostDao.insertJobPost(jobPost);
    }

    public void deleteJobPostById(int id) {
        jobPostDao.deleteJobPost(id);
    }

    public JobPostAndCompany getJobPostDetails(int id) {
        return jobPostDao.getJobPostDetails(id).orElseThrow(PropertyNotFoundException::new);
    }

    public List<JobPostAndCompany> filterJobPosts(String content, String job_title, String position, String workplace, String location) {
        return jobPostDao.filterJobs(content, job_title, position, workplace, location);
    }

    public void apply(int user_id, int post_id) {
        jobPostDao.apply(user_id, post_id);
    }

    public List<JobPostAndCompany> getAppliedJobs(int id) {
        return jobPostDao.getAppliedJobs(id);
    }

}
