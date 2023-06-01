package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.Interest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterestRowMapper implements RowMapper<Interest> {
    @Override
    public Interest mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Interest(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("area")
        );
    }
}
