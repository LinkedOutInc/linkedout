package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.ReactionDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReactionRepository implements ReactionDao {

    private final JdbcTemplate jdbcTemplate;

    public ReactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
