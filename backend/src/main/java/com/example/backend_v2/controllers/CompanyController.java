package com.example.backend_v2.controllers;

import com.example.backend_v2.models.Company;
import com.example.backend_v2.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getPersons() {
        return companyService.getCompanies();
    }

    @GetMapping("{company_id}")
    public Company getPersonById(@PathVariable("company_id") Integer company_id) {
        return companyService.getCompanyById(company_id);
    }

    @PostMapping
    public void insertCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable("id") Integer id) {
        companyService.deleteCompanyById(id);
    }
}