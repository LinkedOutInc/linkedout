package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CommentRowMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Comment(
                rs.getInt("comment_ID"),
                rs.getInt("post_ID"),
                rs.getString("content"),
                ((Timestamp) rs.getObject("date")).toLocalDateTime()
        );
    }
}
