package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.UserReaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserReactionRowMapper implements RowMapper<UserReaction> {
    @Override
    public UserReaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserReaction(
                rs.getInt("user_ID"),
                rs.getInt("reaction_ID"),
                rs.getInt("post_ID")
        );
    }
}
