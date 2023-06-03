package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.SystemReportDao;
import app.linkedout.backend_v2.models.RoleCount;
import app.linkedout.backend_v2.models.SystemReport;
import app.linkedout.backend_v2.repositories.rowMappers.Report1RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SytemReportRepository implements SystemReportDao {

    private final JdbcTemplate jdbcTemplate;

    public SytemReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RoleCount> generateReport() {
        var sql = """
                SELECT COUNT(P.role) AS count, P.role
                FROM Person AS P
                GROUP BY role;
                """;
        var sqlupd = """
                INSERT INTO SystemReport(type, date)
                VALUES(?,?);
                """;
        jdbcTemplate.update(sqlupd, "Role count report", new Date());
        return jdbcTemplate.query(sql, new Report1RowMapper());
    }

    @Override
    public int deleteReport(int id) {
        return 0;
    }
}
