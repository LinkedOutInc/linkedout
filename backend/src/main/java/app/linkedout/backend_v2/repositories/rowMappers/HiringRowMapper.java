package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.Hiring;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HiringRowMapper implements RowMapper<Hiring> {
    @Override
    public Hiring mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Hiring(rs.getString("job_title"), rs.getInt("apply_count"));
    }
}
