package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.CompanyDao;
import app.linkedout.backend_v2.models.Company;
import app.linkedout.backend_v2.repositories.rowMappers.CompanyRowMapper;
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
                INSERT INTO Company(name, location, about, domain)
                VALUES(?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, company.name(), company.location(), company.about(), company.domain());
    }

    @Override
    public int deleteCompanyById(int id) {
        var sql = """
                DELETE FROM JobPost
                WHERE company_ID = ?;
                DELETE FROM Exp_company
                WHERE company_ID = ?;
                DELETE FROM Company
                WHERE company_ID = ?;
                """;
        return jdbcTemplate.update(sql, id, id, id);
    }

    @Override
    public Optional<Company> getCompanyById(int id) {
        var sql = """
                SELECT  * FROM Company
                WHERE company_ID = ?;
                """;
        return jdbcTemplate.query(sql, new CompanyRowMapper(), id).stream().findFirst();
    }

    @Override
    public int updateCompanyById(int id, Company company)
    {
        var sql = """
                UPDATE Company
                SET name = ?, location = ?, about = ?, domain = ?, company_picture = ?
                WHERE company_ID = ?;
                """;
        return jdbcTemplate.update(sql, company.name(), company.location(), company.about(), company.domain(), company.company_picture(), id);
    }

}
