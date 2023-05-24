package com.example.backend_v2.repositories;

import com.example.backend_v2.dao.JobPostDao;
import com.example.backend_v2.models.JobPost;
import com.example.backend_v2.repositories.rowMappers.JobPostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class JobPostRepository implements JobPostDao {

    private final JdbcTemplate jdbcTemplate;

    public JobPostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<JobPost> getJobs() {
        var sql = """
                SELECT post_ID, date, content, job_title, workplace, jp.location AS location, position, company_ID, name AS company_name, company_ID
                FROM JobPost AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE date > GETDATE();
                """;
        return jdbcTemplate.query(sql, new JobPostRowMapper());
    }

    @Override
    public int insertJobPost(JobPost jobPost) {
        var sql = """
                INSERT INTO JobPost(post_id, date, content, job_title, company_id, workplace, location, position, profession)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, jobPost.post_id(), jobPost.date(), jobPost.content(), jobPost.job_title(), jobPost.company_id(), jobPost.workplace(), jobPost.location(), jobPost.position(), jobPost.profession());
    }

    @Override
    public int deleteJobPost(int id) {
        var sql = """
                DELETE FROM JobPost
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<JobPost> getJobPostDetails(int id) {
        var sql = """
                SELECT *
                FROM JobPost AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE post_ID = ?
                """;
        return jdbcTemplate.query(sql, new JobPostRowMapper(), id).stream().findFirst();
    }

    @Override
    public List<JobPost> filterJobs(String content, String job_title, String position, String workplace, String location) {
        var sql = """
                SELECT post_ID, date, content, job_title, workplace, jp.location AS location, position, company_ID, name AS company_name, company_ID
                FROM JobPost AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE (content LIKE '%?%' OR job_title LIKE '%?%' OR name LIKE '%?%') AND position = ? AND workplace = ? AND jp.location = ? AND date > GETDATE();
                """;
        return jdbcTemplate.query(sql, new JobPostRowMapper(), content, job_title, position, workplace, location);
    }

    @Override
    public List<JobPost> getAppliedJobs(int id) {
        var sql = """
                SELECT post_ID, date, content, job_title, workplace, jp.location AS location, position, company_ID, name AS company_name, company_ID
                FROM (JobPost NATURAL JOIN Applies) AS jp JOIN Company AS c ON jp.company_ID = c.company_ID
                WHERE user_ID = ?
                """;
        return jdbcTemplate.query(sql, new JobPostRowMapper(), id);
    }

    @Override
    public int apply(int user_id, int post_id) {
        var sql = """
                INSERT INTO Applies (user_ID, post_ID)
                VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, user_id, post_id);
    }
}
