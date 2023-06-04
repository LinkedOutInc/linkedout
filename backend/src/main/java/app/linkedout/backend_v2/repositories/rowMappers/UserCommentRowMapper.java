package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.UserComment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCommentRowMapper implements RowMapper<UserComment> {
    @Override
    public UserComment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserComment(
                rs.getInt("comment_ID"),
                rs.getInt("user_ID")
        );
    }
}
