package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.RoleCount;
import app.linkedout.backend_v2.models.SystemReport;

import java.util.List;

public interface SystemReportDao {
    List<RoleCount> generateReport();
    int deleteReport(int id);
}
