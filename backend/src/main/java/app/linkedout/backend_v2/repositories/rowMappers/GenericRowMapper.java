package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.UserReaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

public class GenericRowMapper implements RowMapper<HashMap<String, Object>> {
    @Override
    public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        HashMap<String, Object> result = new HashMap<>();
        System.out.println("TEST 1");
        return result;


//        return new UserReaction(
//                rs.getInt("user_ID"),
//                rs.getInt("reaction_ID"),
//                rs.getInt("post_ID")
//        );
    }
}
