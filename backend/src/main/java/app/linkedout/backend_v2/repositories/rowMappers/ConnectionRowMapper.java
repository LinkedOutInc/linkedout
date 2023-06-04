package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.Connection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionRowMapper implements RowMapper<Connection> {
    @Override
    public Connection mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Connection(
                rs.getInt("user_ID_1"),
                rs.getInt("user_ID_2"),
                rs.getString("status")
        );
    }
}
