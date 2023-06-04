package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.ExperienceDao;
import app.linkedout.backend_v2.dao.FileDao;
import app.linkedout.backend_v2.models.Company;
import app.linkedout.backend_v2.models.Experience;
import app.linkedout.backend_v2.models.ExperienceAndCompany;
import app.linkedout.backend_v2.models.File;
import app.linkedout.backend_v2.repositories.rowMappers.CompanyRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.ExperienceAndCompanyRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.ExperienceRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.FileRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FileRepository implements FileDao {

    private final JdbcTemplate jdbcTemplate;

    public FileRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<File> getFilesByUserIdAndType(int user_id, String content_type) {
        var sql = """
                SELECT *
                FROM File 
                WHERE user_id = ? AND contentType = ?
                """;
        return jdbcTemplate.query(sql, new FileRowMapper(), user_id, content_type);
    }

    @Override
    public int insertFile(File file, int user_id) {
        var sql = """
                INSERT INTO File (file_id, user_id, content, fileName, fileType, uploadTime, contentType)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, file.file_id(), user_id, file.content(), file.fileName(), file.fileType(), file.uploadTime(), file.contentType());

    }

    @Override
    public int updateFile(File file)
    {
        var sql = """
                UPDATE File
                SET file_id = ?, content = ?, fileName = ?, fileType = ?, uploadTime = ?, contentType = ?
                WHERE user_id = ? AND content_type = ?;
                """;
        return jdbcTemplate.update(sql, file.file_id(), file.content(), file.fileName(), file.fileType(), file.uploadTime(), file.contentType(), file.user_id(), file.contentType());
    }

}
