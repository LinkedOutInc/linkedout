package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.models.Hiring;
import app.linkedout.backend_v2.repositories.HiringReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringReportService {

    private final HiringReportRepository hiringReportRepository;

    public HiringReportService(HiringReportRepository hiringReportRepository) {
        this.hiringReportRepository = hiringReportRepository;
    }

    public List<Hiring> generateReport() {
        return hiringReportRepository.generateReport();
    }
}

