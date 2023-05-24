package com.example.backend_v2.repositories.rowMappers;

import com.example.backend_v2.models.CareerExpert;
import com.example.backend_v2.models.Experience;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperienceRowMapper implements RowMapper<Experience> {
    @Override
    public Experience mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Experience(
                rs.getInt("exp_id"),
                rs.getInt("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("type"),
                rs.getDate("start_date"),
                rs.getDate("end_date")
        );
    }
}
