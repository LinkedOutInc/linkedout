package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.JobPostDao;
import app.linkedout.backend_v2.models.CareerExpert;
import app.linkedout.backend_v2.models.JobPost;
import app.linkedout.backend_v2.models.JobPostAndCompany;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.el.PropertyNotFoundException;

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
