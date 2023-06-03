package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.PersonDao;
import app.linkedout.backend_v2.dao.SystemReportDao;
import app.linkedout.backend_v2.models.RoleCount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final PersonDao personDao;
    private final SystemReportDao systemReportDao;

    public AdminService(PersonDao personDao, SystemReportDao systemReportDao) {
        this.personDao = personDao;
        this.systemReportDao = systemReportDao;
    }

    public List<RoleCount> generateReport() {
        return systemReportDao.generateReport();
    }

}
