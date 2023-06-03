package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.Reaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ReactionRowMapper implements RowMapper<Reaction> {
    @Override
    public Reaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Reaction(
                rs.getInt("reaction_ID"),
                rs.getString("type"),
                (LocalDateTime) rs.getObject("date")
        );
    }
}
