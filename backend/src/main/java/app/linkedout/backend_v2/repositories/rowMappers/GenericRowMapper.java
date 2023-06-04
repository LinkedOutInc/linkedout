package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.UserReaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

public class GenericRowMapper implements RowMapper<HashMap<String, Object>> {
    @Override
    public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        HashMap<String, Object> result = new HashMap<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
            String key = metaData.getColumnName(colIndex);
            Object val = rs.getObject(colIndex);

            result.put(key, val);
        }

        return result;
    }
}
