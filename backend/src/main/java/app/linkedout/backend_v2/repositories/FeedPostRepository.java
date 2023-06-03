package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.FeedPostDao;
import app.linkedout.backend_v2.repositories.rowMappers.GenericRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.HiringRowMapper;
import app.linkedout.backend_v2.services.SessionService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
