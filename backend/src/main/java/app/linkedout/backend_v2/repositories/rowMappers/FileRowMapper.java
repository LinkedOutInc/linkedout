package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.File;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileRowMapper implements RowMapper<File> {
    @Override
    public File mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new File(
                rs.getInt("file_id"),
                rs.getInt("user_id"),
                rs.getString("content"),
                rs.getString("fileName"),
                rs.getString("fileType"),
                rs.getDate("uploadTime"),
                rs.getString("contentType")
        );
    }
}
