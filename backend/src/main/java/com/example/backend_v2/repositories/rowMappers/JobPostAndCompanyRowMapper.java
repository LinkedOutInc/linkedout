package com.example.backend_v2.repositories.rowMappers;

import com.example.backend_v2.models.JobPost;
import com.example.backend_v2.models.JobPostAndCompany;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobPostAndCompanyRowMapper implements RowMapper<JobPostAndCompany> {
    @Override
    public JobPostAndCompany mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new JobPostAndCompany(
                rs.getInt("post_id"),
                rs.getDate("date"),
                rs.getString("content"),
                rs.getString("job_title"),
                rs.getInt("company_id"),
                rs.getString("workplace"),
                rs.getString("location"),
                rs.getString("position"),
                rs.getString("profession"),
                rs.getString("name"),
                rs.getString("about"),
                rs.getString("domain"),
                rs.getBlob("company_picture")
        );
    }
}
