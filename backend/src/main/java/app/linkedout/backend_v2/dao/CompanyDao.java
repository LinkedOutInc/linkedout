package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDao {
    List<Company> getCompanies();
    int insertCompany(Company company);
    int deleteCompanyById(int id);
    Optional<Company> getCompanyById(int id);
    int updateCompanyById(int id, Company company);
}