

package app.linkedout.backend_v2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import app.linkedout.backend_v2.models.Company;
import app.linkedout.backend_v2.services.CompanyService;

@RestController
@RequestMapping(path = "api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{company_id}")
    public Company getCompanyById(@PathVariable("company_id") Integer company_id) {
        return companyService.getCompanyById(company_id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("{company_id}")
    public void deleteCompany(@PathVariable("company_id") Integer company_id) {
        companyService.deleteCompanyById(company_id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("{company_id}")
    public void updateCompany(@PathVariable("company_id") Integer company_id, @RequestBody Company company)
    {
        companyService.updateCompany(company_id, company);
    }
}