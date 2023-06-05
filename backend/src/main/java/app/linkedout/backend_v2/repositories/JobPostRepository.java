package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.JobPostDao;
import app.linkedout.backend_v2.models.ExperienceAndCompany;
import app.linkedout.backend_v2.models.JobPost;
import app.linkedout.backend_v2.models.JobPostAndCompany;
import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.repositories.rowMappers.ExperienceAndCompanyRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.JobPostAndCompanyRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.JobPostRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.PersonRowMapper;
import app.linkedout.backend_v2.services.ExperienceService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;


import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Repository
public class JobPostRepository implements JobPostDao {

    private final JdbcTemplate jdbcTemplate;
    private final ExperienceService experienceService;

    public JobPostRepository(JdbcTemplate jdbcTemplate, ExperienceService experienceService) {
        this.jdbcTemplate = jdbcTemplate;
        this.experienceService = experienceService;
    }

    @Override
    public List<JobPostAndCompany> getJobs() {
        var sql = """
                SELECT *
                FROM JobPost AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE date > CURRENT_DATE;
                """;
        return jdbcTemplate.query(sql, new JobPostAndCompanyRowMapper());
    }

    @Override
    public int insertJobPost(JobPost jobPost, int user_id) {
        var sqlRecruiterCompany = """
                SELECT *
                FROM (Experience NATURAL JOIN Exp_company) AS e JOIN Company
                AS c ON e.company_ID = c.company_ID
                WHERE e.user_ID = ? AND e.type != 'EDUCATION' AND e.end_date is null;
                """;
        Optional<ExperienceAndCompany> recruiterCompany = jdbcTemplate.query(sqlRecruiterCompany, new ExperienceAndCompanyRowMapper(), user_id).stream().findFirst();
        if(recruiterCompany.isEmpty()) {
            return -1;
        }
        var sql = """
                INSERT INTO JobPost(date, content, job_title, company_id, workplace, position, profession)
                VALUES(?, ?, ?, ?, ?, ?, ?);
                """;
        var sqlupd = """
                INSERT INTO Hiring_Reports(JobPost_id, apply_count)
                (SELECT J.post_ID, 0 FROM JobPost AS J WHERE J.job_title = ?);
                """;
        jdbcTemplate.update(sqlupd, jobPost.job_title());
        return jdbcTemplate.update(sql, jobPost.date(), jobPost.content(), jobPost.job_title(), recruiterCompany.get().company_ID(), jobPost.workplace(), jobPost.position(), jobPost.profession());
    }

    @Override
    public int deleteJobPost(int id) {
        var sql = """
                DELETE FROM applies
                WHERE post_ID = ?;
                DELETE FROM JobPost
                WHERE post_ID = ?;
                """;
        return jdbcTemplate.update(sql, id, id);
    }

    @Override
    public Optional<JobPostAndCompany> getJobPostDetails(int id) {
        var sql = """
                SELECT *
                FROM JobPost AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE post_ID = ?
                """;
        return jdbcTemplate.query(sql, new JobPostAndCompanyRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<JobPostAndCompany> filterJobs(String content, String job_title, String position, String workplace, String location) {
        var sql = """
                SELECT *
                FROM JobPost AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE (content LIKE CONCAT('%', ?, '%') OR job_title LIKE CONCAT('%', ?, '%') OR name LIKE CONCAT('%', ?, '%')) AND position LIKE CONCAT('%', ?, '%') AND workplace LIKE CONCAT('%', ?, '%') AND location LIKE CONCAT('%', ?, '%') AND date > CURRENT_DATE;
                """;
        //return jdbcTemplate.query(sql, new JobPostAndCompanyRowMapper(), content, job_title, content, position, workplace, location);
        return jdbcTemplate.query(sql, new JobPostAndCompanyRowMapper(), new SqlParameterValue(Types.VARCHAR, content),
                new SqlParameterValue(Types.VARCHAR, job_title),
                new SqlParameterValue(Types.VARCHAR, content),
                new SqlParameterValue(Types.VARCHAR, position),
                new SqlParameterValue(Types.VARCHAR, workplace),
                new SqlParameterValue(Types.VARCHAR, location));
    }

    @Override
    public List<JobPostAndCompany> getAppliedJobs(int id) {
        var sql = """
                SELECT *
                FROM (JobPost NATURAL JOIN Applies) AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE user_ID = ?
                """;
        return jdbcTemplate.query(sql, new JobPostAndCompanyRowMapper(), id);
    }

    @Override
    public int apply(int user_id, int post_id) {
        var sql = """
                INSERT INTO Applies (user_ID, post_ID)
                VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, user_id, post_id);
    }
    @Override
    public List<Person> getApplicantsOfPost(int post_id) {
        var sql = """
                SELECT *
                FROM Person
                WHERE id IN (SELECT user_ID FROM Applies WHERE post_ID = ?)
                """;
        return jdbcTemplate.query(sql, new PersonRowMapper(), post_id);
    }
}
