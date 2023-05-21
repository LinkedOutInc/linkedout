package com.example.backend_v2.repositories;

import com.example.backend_v2.dao.RecruiterDao;
import com.example.backend_v2.models.Recruiter;
import com.example.backend_v2.repositories.rowMappers.PersonRowMapper;
import com.example.backend_v2.repositories.rowMappers.RecruiterRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecruiterRepository implements RecruiterDao {

    private final JdbcTemplate jdbcTemplate;

    public RecruiterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Recruiter> getRecruiters() {
        var sql = """
                SELECT *
                FROM Recruiter
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new RecruiterRowMapper());
    }

    @Override
    public int insertRecruiter(Recruiter recruiter) {
        var sql = """
                INSERT INTO Recruiter(name, surname, email, password, job_title, location, role, is_hiring)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, recruiter.name(), recruiter.surname(), recruiter.email(), recruiter.password(), recruiter.job_title(), recruiter.location(), recruiter.role(), recruiter.is_hiring());
    }

    @Override
    public int deleteRecruiterById(int id) {
        var sql = """
                DELETE FROM Recruiter
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Recruiter> getRecruiterById(int id) {
        var sql = """
                SELECT FROM Recruiter
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new RecruiterRowMapper()).stream().findFirst();
    }
}
