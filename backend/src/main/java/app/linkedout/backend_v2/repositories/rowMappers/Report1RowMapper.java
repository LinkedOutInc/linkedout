package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.RoleCount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Report1RowMapper implements RowMapper<RoleCount> {
    @Override
    public RoleCount mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new RoleCount(
                rs.getString("role"),
                rs.getInt("count")
        );
    }
}
