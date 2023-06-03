package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.FeedPost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class FeedPostRowMapper implements RowMapper<FeedPost> {
    @Override
    public FeedPost mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FeedPost(
                rs.getInt("post_ID"),
                rs.getString("title"),
                (LocalDateTime) rs.getObject("date"),
                rs.getString("content"),
                rs.getString("image"),
                rs.getString("type")
        );
    }
}
