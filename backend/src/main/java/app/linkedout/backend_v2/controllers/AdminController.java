package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.Hiring;
import app.linkedout.backend_v2.models.RoleCount;
import app.linkedout.backend_v2.services.AdminService;
import app.linkedout.backend_v2.services.HiringReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    private final AdminService adminService;
    private final HiringReportService hiringReportService;

    public AdminController(AdminService adminService, HiringReportService hiringReportService) {
        this.adminService = adminService;
        this.hiringReportService = hiringReportService;
    }

    @GetMapping("/generateRoleCountReport")
    public ResponseEntity<List<RoleCount>> generateRoleCountReport() {
        return ResponseEntity.ok().body(adminService.generateReport());
    }

    @GetMapping("/generateHiringReport")
    public ResponseEntity<List<Hiring>> generateHiringReport() {
        return ResponseEntity.ok().body(hiringReportService.generateReport());
    }
}
