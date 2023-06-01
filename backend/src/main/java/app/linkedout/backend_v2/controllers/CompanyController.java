

package app.linkedout.backend_v2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.linkedout.backend_v2.models.Company;
import app.linkedout.backend_v2.services.CompanyService;

@RestController
@RequestMapping(path = "api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("{company_id}")
    public Company getCompanyById(@PathVariable("company_id") Integer company_id) {
        return companyService.getCompanyById(company_id);
    }

    @PostMapping
    public void insertCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @DeleteMapping("{company_id}")
    public void deleteCompany(@PathVariable("company_id") Integer company_id) {
        companyService.deleteCompanyById(company_id);
    }

    @PutMapping("{company_id}")
    public void updateCompany(@PathVariable("company_id") Integer company_id, @RequestBody Company company)
    {
        companyService.updateCompany(company_id, company);
    }
}