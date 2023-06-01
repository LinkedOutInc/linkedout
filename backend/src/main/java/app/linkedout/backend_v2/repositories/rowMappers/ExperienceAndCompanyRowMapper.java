package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.ExperienceAndCompany;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperienceAndCompanyRowMapper implements RowMapper<ExperienceAndCompany> {
    @Override
    public ExperienceAndCompany mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ExperienceAndCompany(
            rs.getInt("exp_id"),
            rs.getInt("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("type"),
            rs.getDate("start_date"),
            rs.getDate("end_date"),
            rs.getInt("company_ID"),
            rs.getString("name"),
            rs.getString("location"),
            rs.getString("about"),
            rs.getString("domain"),
            rs.getBlob("company_picture"));
    }
}
