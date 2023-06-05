package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.CommentDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.dto.Success;
import app.linkedout.backend_v2.models.Comment;
import app.linkedout.backend_v2.models.FeedPost;
import app.linkedout.backend_v2.repositories.rowMappers.CommentRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.FeedPostRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.GenericRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CommentRepository implements CommentDao {

    private final JdbcTemplate jdbcTemplate;

    public CommentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HashMap<String, Object>> getComments(int postId, int offset) {
        var sql = """
                SELECT c.comment_ID, c.content, c.date, c.user_ID, u.name, u.surname, u.job_title
                FROM (Comment NATURAL JOIN User_comments) AS c
                    JOIN Person AS u ON c.user_ID = u.id
                WHERE c.post_ID = ?
                ORDER BY c.date DESC
                LIMIT 20
                OFFSET ?;                
                """;
        return jdbcTemplate.query(sql, new GenericRowMapper(), postId, offset);
    }

    @Override
    public Object insertComment(Comment comment, int userId) {
        // Insert on Comment
        var sqlComment = """
                INSERT INTO Comment (comment_ID, post_ID, content, date)
                VALUES (DEFAULT, ?, ?, ?);
                """;
        int queryResult = jdbcTemplate.update(sqlComment, comment.post_ID(),
                comment.content(), comment.date());
        if (queryResult <= 0) {
            return Error.create(500, "Comment could not be inserted.");
        }

        // Insert on FeedPostUser
        var sqlUserComment = """
                INSERT INTO User_comments (user_ID, comment_ID)
                VALUES (?, (SELECT comment_ID FROM Comment WHERE post_ID = ? AND content = ? AND date = ?));
                """;
        queryResult = jdbcTemplate.update(sqlUserComment, userId, comment.post_ID(),
                comment.content(), comment.date());
        if (queryResult <= 0) {
            return Error.create(500, "Comment could not be linked to the user.");
        }

        return Success.create("Comment posted.");
    }

    @Override
    public Object getComment(int commentId) {
        // Get selected post id from FeedPost
        var sqlQuery = """
                SELECT *
                FROM Comment NATURAL JOIN User_Comments
                WHERE comment_id = ?;
                """;
        List<HashMap<String, Object>> tempComments = jdbcTemplate.query(sqlQuery, new GenericRowMapper(), commentId);
        if (tempComments.isEmpty()) {
            return Error.create(500, "Comment not found.");
        }
        return tempComments.get(0);
    }

    @Override
    public Object deleteComment(int commentId) {
        // Delete from UserComments
        var sqlUserComments = """
              DELETE FROM User_comments
              WHERE comment_ID = ?;
                """;
        int queryResult = jdbcTemplate.update(sqlUserComments, commentId);
        if (queryResult <= 0) {
            return Error.create(500, "Comment could not be unlinked.");
        }

        // Delete from Comment
        var sqlComment = """
                DELETE FROM Comment
                WHERE comment_ID = ?;
                """;
        queryResult = jdbcTemplate.update(sqlComment, commentId);
        if (queryResult <= 0) {
            return Error.create(500, "Comment could not be deleted.");
        }

        return Success.create("Comment deleted.");
    }
}
