package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.Hiring;
import app.linkedout.backend_v2.models.HiringReport;

import java.util.List;

public interface HiringReportDao {
    List<Hiring> generateReport();
    int deleteReport(int id);
    int insertReport(HiringReport hiringReport);
}
