package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.FeedPostDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FeedPostRepository implements FeedPostDao {

    private final JdbcTemplate jdbcTemplate;

    public FeedPostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
