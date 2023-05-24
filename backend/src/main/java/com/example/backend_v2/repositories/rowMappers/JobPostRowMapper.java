package com.example.backend_v2.repositories.rowMappers;

import com.example.backend_v2.models.JobPost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobPostRowMapper implements RowMapper<JobPost> {
    @Override
    public JobPost mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new JobPost(
                rs.getInt("post_id"),
                rs.getDate("date"),
                rs.getString("content"),
                rs.getString("job_title"),
                rs.getInt("company_id"),
                rs.getString("workplace"),
                rs.getString("location"),
                rs.getString("position"),
                rs.getString("profession")
        );
    }
}
