package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.ConnectionSuggestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionSuggestionRowMapper implements RowMapper<ConnectionSuggestion> {
    @Override
    public ConnectionSuggestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ConnectionSuggestion(
                rs.getInt("user_ID_1"),
                rs.getInt("user_ID_2"),
                rs.getString("type")
        );
    }
}
