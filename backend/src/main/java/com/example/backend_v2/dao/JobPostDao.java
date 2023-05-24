package com.example.backend_v2.dao;

import com.example.backend_v2.models.JobPost;

import java.util.List;
import java.util.Optional;

public interface JobPostDao {
    List<JobPost> getJobs();
    int insertJobPost(JobPost jobPost);
    int deleteJobPost(int id);
    Optional<JobPost> getJobPostDetails(int id);
    List<JobPost> filterJobs(String content, String job_title, String position, String workplace, String location);
    List<JobPost> getAppliedJobs(int id);
    int apply(int user_id, int post_id);
}
