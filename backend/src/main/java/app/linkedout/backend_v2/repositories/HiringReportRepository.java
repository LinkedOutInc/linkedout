package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.HiringReportDao;
import app.linkedout.backend_v2.models.Hiring;
import app.linkedout.backend_v2.models.HiringReport;
import app.linkedout.backend_v2.repositories.rowMappers.HiringRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HiringReportRepository implements HiringReportDao {

    private final JdbcTemplate jdbcTemplate;

    public HiringReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hiring> generateReport() {
        var sql = """
                SELECT J.job_title, H.apply_count
                FROM JobPost AS J, Hiring_Reports AS H
                WHERE J.post_ID = H.JobPost_id;
                """;
        return jdbcTemplate.query(sql, new HiringRowMapper());
    }

    @Override
    public int deleteReport(int id) {
        return 0;
    }

    @Override
    public int insertReport(HiringReport hiringReport) {
        var sql = """
                INSERT INTO Hiring_Reports(JobPost_id, Report_id, apply_count)
                VALUES(?, ?, ?);
                """;
        return jdbcTemplate.update(sql, hiringReport.JobPost_id(), hiringReport.Report_id(), hiringReport.apply_count());
    }
}
