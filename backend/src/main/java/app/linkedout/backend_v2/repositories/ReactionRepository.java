package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.ReactionDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.dto.Success;
import app.linkedout.backend_v2.models.Reaction;
import app.linkedout.backend_v2.models.UserReaction;
import app.linkedout.backend_v2.repositories.rowMappers.GenericRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.ReactionRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.UserReactionRowMapper;
import org.apache.catalina.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ReactionRepository implements ReactionDao {

    private final JdbcTemplate jdbcTemplate;

    public ReactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Object getReactionId(String reactionType) {
        var sql = """
                SELECT reaction_id
                FROM Reaction
                WHERE type = ?
                """;
        List<HashMap<String, Object>> tempReactions = jdbcTemplate.query(sql, new GenericRowMapper(), reactionType);
        if (tempReactions.isEmpty()) {
            return Error.create(400, "Invalid reaction type.");
        }
        return tempReactions.get(0).get("reaction_id");
    }

    @Override
    public Object getUserReactionList(int postId, int userId) {
        var sql = """
                SELECT *
                FROM User_Reactions
                WHERE user_id = ? AND post_id = ?;
                """;
        return jdbcTemplate.query(sql, new UserReactionRowMapper(), userId, postId);
    }

    @Override
    public Object insertUserReaction(int postId, int reactionId, int userId) {
        // Insert on UserReaction
        var sql = """
                INSERT INTO User_reactions (user_ID, post_ID, reaction_ID)
                VALUES (?, ?, ?)
                """;
        int queryResult = jdbcTemplate.update(sql, userId, postId, reactionId);
        if (queryResult <= 0) {
            return Error.create(500, "Reaction could not be inserted.");
        }
        return Success.create("Reaction inserted.");
    }

    @Override
    public Object updateUserReaction(int postId, int reactionId, int userId) {
        // Update on UserReaction
        var sql = """
                UPDATE User_reactions
                SET reaction_ID = ?
                WHERE user_ID = ? AND post_ID = ?;
                """;
        int queryResult = jdbcTemplate.update(sql, reactionId, userId, postId);
        if (queryResult <= 0) {
            return Error.create(500, "Reaction could not be updated.");
        }
        return Success.create("Reaction updated.");
    }

    @Override
    public List<HashMap<String, Object>> getReactionCounts(int postId) {
        var sql = """
              SELECT type, COUNT(user_id)
              FROM Reaction NATURAL JOIN User_reactions
              WHERE post_id = ?
              GROUP BY type;
                """;
        return jdbcTemplate.query(sql, new GenericRowMapper(), postId);
    }

    @Override
    public Object removeUserReaction(int postId, int userId) {
        var sql = """
              DELETE FROM User_reactions
              WHERE user_ID = ? AND post_ID = ?;
                """;
        jdbcTemplate.update(sql, userId, postId);
        return Success.create("Reaction removed.");
    }

    @Override
    public Object removeUserReactions(int postId) {
        var sql = """
              DELETE FROM User_reactions
              WHERE post_ID = ?;
                """;
        jdbcTemplate.update(sql, postId);
        return Success.create("Reaction removed.");
    }
}
