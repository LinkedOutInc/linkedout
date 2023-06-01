package com.example.backend_v2.repositories;

import com.example.backend_v2.dao.CompanyDao;
import com.example.backend_v2.models.Company;
import com.example.backend_v2.repositories.rowMappers.CompanyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepository implements CompanyDao { 
    private final JdbcTemplate jdbcTemplate;
    
    public CompanyRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Company> getCompanies() {
        String sql = "SELECT * FROM Company;";
        return jdbcTemplate.query(sql, new CompanyRowMapper());
    }

    @Override
    public int insertCompany(Company company) {
        var sql = """
                INSERT INTO Company(company_ID, name, location, about, domain, company_picture)
                VALUES(?, ?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, company.company_ID(), company.name(), company.location(), company.about(), company.domain(), company.company_picture());
    }

    @Override
    public int deleteCompanyById(int id) {
        var sql = """
                DELETE FROM Company
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Company> getCompanyById(int id) {
        var sql = """
                SELECT  * FROM CareerExpert
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new CompanyRowMapper(), id).stream().findFirst();
    }

    @Override
    public int updateCompanyById(int id, Company company)
    {
        var sql = """
                UPDATE CareerExpert
                SET name = ?, location = ?, about = ?, domain = ?, company_picture = ?
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, company.company_ID(), company.name(), company.location(), company.about(), company.domain(), company.company_picture());
    }

}
