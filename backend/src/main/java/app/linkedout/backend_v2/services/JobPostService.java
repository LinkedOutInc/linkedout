package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.HiringReportDao;
import app.linkedout.backend_v2.dao.JobPostDao;
import app.linkedout.backend_v2.models.HiringReport;
import app.linkedout.backend_v2.models.JobPost;
import app.linkedout.backend_v2.models.JobPostAndCompany;
import app.linkedout.backend_v2.models.Person;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

import javax.el.PropertyNotFoundException;

@Service
public class JobPostService {

    private final JobPostDao jobPostDao;
    private final HiringReportDao hiringReportDao;

    public JobPostService(JobPostDao jobPostDao, HiringReportDao hiringReportDao) {
        this.jobPostDao = jobPostDao;
        this.hiringReportDao = hiringReportDao;
    }

    public List<JobPostAndCompany> getJobPosts() {
        return jobPostDao.getJobs();
    }
    public List<JobPostAndCompany> getMyJobPosts(int user_id) {
        return jobPostDao.getMyJobs(user_id);
    }

    public void addJobPost(JobPost jobPost, int user_id) {
        jobPostDao.insertJobPost(jobPost, user_id);
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
    public List<Person> getApplicantsOfPost(int post_id) {
        return jobPostDao.getApplicantsOfPost(post_id);
    }

    public int getApplicationCount() {
        return jobPostDao.getApplicationCount();
    }

    public List<JobPostAndCompany> getJobsByDate(String date1, String date2) throws ParseException {
        return jobPostDao.filterJobsByDate(date1, date2);
    }
}
