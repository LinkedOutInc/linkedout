package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.FeedPostUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedPostUserRowMapper implements RowMapper<FeedPostUser> {
    @Override
    public FeedPostUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FeedPostUser(
                rs.getInt("post_ID"),
                rs.getInt("user_ID")
        );
    }
}
