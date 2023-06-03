package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.FeedPostDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.dto.Success;
import app.linkedout.backend_v2.models.FeedPost;
import app.linkedout.backend_v2.models.FeedPostUser;
import app.linkedout.backend_v2.repositories.rowMappers.FeedPostRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.GenericRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.HiringRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.Report1RowMapper;
import app.linkedout.backend_v2.services.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class FeedPostRepository implements FeedPostDao {

    private final JdbcTemplate jdbcTemplate;

    public FeedPostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HashMap<String, Object>> getFeed(int userId, int offset) {
        var sql = """
                SELECT p.post_ID, p.title, p.content, p.image, p.type, p.date, fp.user_ID, u.name, u.surname, u.job_title
                FROM FeedPost AS p
                    JOIN Feed_posts AS fp ON p.post_ID = fp.post_ID
                    JOIN Person AS u ON fp.user_ID = u.id
                WHERE u.id IN (
                    SELECT c1.user_ID_1
                    FROM Connections AS c1
                    WHERE c1.user_ID_2 = ? AND c1.status = 'ACCEPTED'
                    UNION
                    SELECT c2.user_ID_2
                    FROM Connections AS c2
                    WHERE c2.user_ID_1 = ? AND c2.status = 'ACCEPTED'
                    UNION
                    SELECT ce.id
                    FROM CareerExpert AS ce
                    WHERE ce.field IN (
                        SELECT ix.area
                        FROM (Interest AS i JOIN Interests AS ins ON i.id = ins.int_id) AS ix
                        WHERE ix.person_id = ?))
                ORDER BY date DESC
                LIMIT 20
                OFFSET ?;
                """;
        return jdbcTemplate.query(sql, new GenericRowMapper(), userId, userId, userId, offset);
    }

    @Override
    public Object insertPost(int userId, FeedPost feedPost) {
        // Insert on FeedPost
        var sqlFeedPost = """
                INSERT INTO FeedPost(post_ID, title, date, content, image, type)
                VALUES (DEFAULT, ?, ?, ?, ?, ?);
                """;
        int queryResult = jdbcTemplate.update(sqlFeedPost, feedPost.title(),
                feedPost.date(), feedPost.content(), feedPost.image(), feedPost.type());
        if (queryResult <= 0) {
            return Error.create(500, "Post could not be inserted.");
        }

        // Get selected post id from FeedPost
        var sqlQuery = """
                SELECT *
                FROM FeedPost
                WHERE title = ? AND date = ? AND content = ? AND image = ? AND type = ?;
                """;
        List<FeedPost> tempFeedPosts = jdbcTemplate.query(sqlQuery, new FeedPostRowMapper(), feedPost.title(),
                feedPost.date(), feedPost.content(), feedPost.image(), feedPost.type());
        if (tempFeedPosts.isEmpty()) {
            return Error.create(500, "Post id could not retrieved.");
        }
        int newPostId = tempFeedPosts.get(0).post_ID();

        // Insert on FeedPostUser
        var sqlFeedPostUser = """
                INSERT INTO Feed_posts(user_ID, post_ID)
                VALUES (?, ?);
                """;
        queryResult = jdbcTemplate.update(sqlFeedPostUser, userId, newPostId);
        if (queryResult <= 0) {
            return Error.create(500, "Post could not be linked to the user.");
        }

        return Success.create("Post created.");
    }

    @Override
    public Object getPost(int postId) {
        // Get selected post id from FeedPost
        var sqlQuery = """
                SELECT *
                FROM FeedPost NATURAL JOIN Feed_posts
                WHERE post_id = ?;
                """;
        List<HashMap<String, Object>> tempFeedPosts = jdbcTemplate.query(sqlQuery, new GenericRowMapper(), postId);
        if (tempFeedPosts.isEmpty()) {
            return Error.create(500, "Post not found.");
        }
        return tempFeedPosts.get(0);
    }

    @Override
    public Object deletePost(int postId) {
        // Delete from FeedPost
        var sqlFeedPostUser = """
                DELETE FROM Feed_posts
                WHERE post_ID = ?;
                """;
        int queryResult = jdbcTemplate.update(sqlFeedPostUser, postId);
        if (queryResult <= 0) {
            return Error.create(500, "Post could not be unlinked.");
        }

        // Delete from FeedPost
        var sqlFeedPost = """
                DELETE FROM FeedPost
                WHERE post_ID = ?;
                """;
        queryResult = jdbcTemplate.update(sqlFeedPost, postId);
        if (queryResult <= 0) {
            return Error.create(500, "Post could not be deleted.");
        }

        return Success.create("Post deleted.");
    }
}
