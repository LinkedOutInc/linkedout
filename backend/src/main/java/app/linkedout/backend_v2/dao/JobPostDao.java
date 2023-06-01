package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.JobPost;
import app.linkedout.backend_v2.models.JobPostAndCompany;

import java.util.List;
import java.util.Optional;

public interface JobPostDao {
    List<JobPostAndCompany> getJobs();
    int insertJobPost(JobPost jobPost);
    int deleteJobPost(int id);
    Optional<JobPostAndCompany> getJobPostDetails(int id);
    List<JobPostAndCompany> filterJobs(String content, String job_title, String position, String workplace, String location);
    List<JobPostAndCompany> getAppliedJobs(int id);
    int apply(int user_id, int post_id);
}
