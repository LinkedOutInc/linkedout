package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.CommentDao;
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
}
