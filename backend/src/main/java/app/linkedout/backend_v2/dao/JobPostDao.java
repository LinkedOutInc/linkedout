package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.JobPost;
import app.linkedout.backend_v2.models.JobPostAndCompany;
import app.linkedout.backend_v2.models.Person;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface JobPostDao {
    List<JobPostAndCompany> getJobs();
    int insertJobPost(JobPost jobPost);
    int deleteJobPost(int id);
    Optional<JobPostAndCompany> getJobPostDetails(int id);
    List<JobPostAndCompany> filterJobs(String content, String job_title, String position, String workplace, String location, Date start_date, Date end_date);
    List<JobPostAndCompany> getAppliedJobs(int id);
    int apply(int user_id, int post_id);
    List<Person> getApplicantsOfPost(int post_id);
}
