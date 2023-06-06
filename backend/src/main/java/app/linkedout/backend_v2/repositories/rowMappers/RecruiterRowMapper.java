package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.Recruiter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruiterRowMapper implements RowMapper<Recruiter> {
    @Override
    public Recruiter mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Recruiter(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("job_title"),
                rs.getString("location"),
                rs.getString("image"),
                rs.getString("role"),
                rs.getBoolean("is_hiring")
        );
    }
}
