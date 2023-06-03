package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.ConnectionDao;
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

}
