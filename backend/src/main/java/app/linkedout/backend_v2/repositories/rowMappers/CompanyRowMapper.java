package app.linkedout.backend_v2.repositories.rowMappers;

import app.linkedout.backend_v2.models.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyRowMapper implements RowMapper<Company>  {
    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Company(
            rs.getInt("company_ID"),
            rs.getString("name"),
            rs.getString("location"),
            rs.getString("about"),
            rs.getString("domain"),
            rs.getBlob("company_picture")
        );
    }
    
}
