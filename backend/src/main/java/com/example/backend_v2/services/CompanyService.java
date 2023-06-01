package com.example.backend_v2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend_v2.dao.CompanyDao;
import com.example.backend_v2.models.Company;

import jakarta.el.PropertyNotFoundException;

@Service
public class CompanyService 
{
    private final CompanyDao companyDao;

    public CompanyService(CompanyDao companyDao)
    {
        this.companyDao = companyDao;
    }

    public List<Company> getCompanies()
    {
        return companyDao.getCompanies();
    }

    public void addCompany(Company company)
    {
        companyDao.insertCompany(company);
    }

    public void deleteCompanyById(int id)
    {
        companyDao.deleteCompanyById(id);
    }

    public Company getCompanyById(int id)
    {
        return companyDao.getCompanyById(id).orElseThrow(PropertyNotFoundException::new);
    }

    public void updateCompany(int id, Company company)
    {
        companyDao.updateCompanyById(id, company);
    }
}
