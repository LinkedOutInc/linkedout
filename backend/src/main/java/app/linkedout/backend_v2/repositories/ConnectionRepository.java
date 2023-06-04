package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.ConnectionDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.dto.Success;
import app.linkedout.backend_v2.models.Connection;
import app.linkedout.backend_v2.repositories.rowMappers.ConnectionRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.GenericRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ConnectionRepository implements ConnectionDao {

    private final JdbcTemplate jdbcTemplate;

    public ConnectionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Returns:
     * - UNLINKED
     * - LINKED
     * - REQUESTED: waiting for other user to approve
     * - WAITING: waiting current user's approval
     * - UNKNOWN: in case of an error
     */
    @Override
    public String getConnectionStatus(int userId, int targetUserId) {
        var sql = """
              SELECT *
              FROM Connections
              WHERE user_ID_1 = ? AND user_ID_2 = ?
                """;
        List<Connection> tempConnections = jdbcTemplate.query(sql, new ConnectionRowMapper(), userId, targetUserId);
        if (!tempConnections.isEmpty()) {
            if (tempConnections.get(0).status().equals("LINKED")) {
                return "LINKED";
            }
            else if (tempConnections.get(0).status().equals("REQUESTED")) {
                return "REQUESTED";
            }
            return "UNKNOWN";
        }

        tempConnections = jdbcTemplate.query(sql, new ConnectionRowMapper(), targetUserId, userId);
        if (tempConnections.isEmpty()) {
            return "UNLINKED";
        }
        else if (tempConnections.get(0).status().equals("LINKED")) {
            return "LINKED";
        }
        else if (tempConnections.get(0).status().equals("REQUESTED")) {
            return "WAITING";
        }
        return "UNKNOWN";
    }

    @Override
    public Object insertRequest(int userId, int targetUserId) {
        var sql = """
                INSERT INTO Connections
                VALUES (?, ?, 'REQUESTED');
                """;
        int queryResult = jdbcTemplate.update(sql, userId, targetUserId);
        if (queryResult <= 0) {
            return Error.create(500, "Connection request could not be sent.");
        }
        return Success.create("Connection request sent.");
    }
}
