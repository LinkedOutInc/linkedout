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

    @Override
    public Object acceptRequest(int userId, int targetUserId) {
        var sql = """
                UPDATE Connections
                SET status = ?
                WHERE user_ID_1 = ? AND user_ID_2 = ?;
                """;
        int queryResult = jdbcTemplate.update(sql, "LINKED", userId, targetUserId);
        if (queryResult <= 0) {
            return Error.create(500, "Connection request status could not be updated.");
        }
        return Success.create("Connection request accepted.");
    }

    @Override
    public Object deleteConnection(int userId, int targetUserId) {
        var sql = """
              DELETE FROM Connections
              WHERE user_ID_1 = ? AND user_ID_2 = ?;
                """;
        int queryResult = jdbcTemplate.update(sql, userId, targetUserId);
        if (queryResult > 0) {
            return Success.create("Connection deleted");
        }

        queryResult = jdbcTemplate.update(sql, targetUserId, userId);
        if (queryResult > 0) {
            return Success.create("Connection deleted");
        }

        return Error.create(500, "Connection could not be deleted..");
    }

    @Override
    public List<HashMap<String, Object>> getNetwork(int userId, int offset) {
        var sql = """
                (SELECT cs1.user_ID_2 AS user_ID, u1.name, u1.surname, u1.job_title
                FROM Person AS u1 JOIN Connections AS cs1 ON u1.id = cs1.user_ID_2
                WHERE cs1.user_ID_1 = ? AND status = 'LINKED'
                UNION
                SELECT cs2.user_ID_1 AS user_ID, u2.name, u2.surname, u2.job_title
                FROM Person AS u2 JOIN Connections AS cs2 ON u2.id = cs2.user_ID_1
                WHERE cs2.user_ID_2 = ? AND status = 'LINKED')
                LIMIT 10
                OFFSET ?;
                """;
        return jdbcTemplate.query(sql, new GenericRowMapper(), userId, userId, offset);
    }

    @Override
    public List<HashMap<String, Object>> getRequests(int userId, int offset) {
        var sql = """
                SELECT cs1.user_ID_1 AS user_ID, u1.name, u1.surname, u1.job_title
                FROM Person AS u1 JOIN Connections AS cs1 ON u1.id = cs1.user_ID_1
                WHERE cs1.user_ID_2 = ? AND status = 'REQUESTED'
                LIMIT 10
                OFFSET ?;
                """;
        return jdbcTemplate.query(sql, new GenericRowMapper(), userId, offset);
    }

    @Override
    public List<HashMap<String, Object>> getSuggestions(int userId, int offset) {
        var sql = """
                (SELECT cs1.user_ID_2 AS user_ID, u1.name, u1.surname, u1.job_title, cs1.type
                FROM Person AS u1 JOIN ConnectionSuggestions AS cs1 ON u1.id = cs1.user_ID_2
                WHERE cs1.user_ID_1 = ?
                UNION
                SELECT cs2.user_ID_1 AS user_ID, u2.name, u2.surname, u2.job_title, cs2.type
                FROM Person AS u2 JOIN ConnectionSuggestions AS cs2 ON u2.id = cs2.user_ID_1
                WHERE cs2.user_ID_2 = ?)
                LIMIT 10
                OFFSET ?;
                """;
        return jdbcTemplate.query(sql, new GenericRowMapper(), userId, userId, offset);
    }

    @Override
    public List<HashMap<String, Object>> getAlternativeSuggestions(int userId, int offset) {
        var sql = """
                SELECT u.id, u.name, u.surname, u.image, u.job_title
                FROM Person AS u
                WHERE
                    (SELECT COUNT(*)
                    FROM (
                        SELECT i1.person_ID AS p1, i1.int_ID AS int_ID
                        FROM Interests i1
                        WHERE i1.person_ID = ?
                    ) AS t1 NATURAL JOIN (
                        SELECT i2.person_ID AS p2, i2.int_ID AS int_ID
                        FROM Interests i2
                        WHERE i2.person_ID = u.id
                    ) AS t2
                ) > 0
                AND
                u.id NOT IN (
                    (SELECT c1.user_id_1
                    FROM Connections AS c1
                    WHERE c1.user_id_2 = ? AND status = 'LINKED')
                    UNION
                    (SELECT c2.user_id_2
                    FROM Connections AS c2
                    WHERE c2.user_id_1 = ? AND status = 'LINKED')
                )
                AND u.id <> ?
                LIMIT 10
                OFFSET ?;
                """;
        return jdbcTemplate.query(sql, new GenericRowMapper(), userId, userId, userId, userId, offset);
    }
}