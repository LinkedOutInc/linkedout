package com.example.backend_v2.repositories;

import com.example.backend_v2.dao.ExperienceDao;
import com.example.backend_v2.models.Company;
import com.example.backend_v2.models.Experience;
import com.example.backend_v2.repositories.rowMappers.CompanyRowMapper;
import com.example.backend_v2.repositories.rowMappers.ExperienceRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExperienceRepository implements ExperienceDao {

    private final JdbcTemplate jdbcTemplate;

    public ExperienceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Experience> getExperiences(int user_id) {
        var sql = """
                SELECT e.exp_ID AS exp_ID, e.name AS exp_name, e.type AS type, e.title 
                AS title, e.start_date AS start_date, e.end_date AS end_date, c.name AS
                company_name
                FROM (Experience NATURAL JOIN Exp_company) AS e JOIN Company
                AS c ON e.company_ID = c.company_ID
                WHERE user_ID = ? AND e.type != 'EDUCATION'
                """;
        return jdbcTemplate.query(sql, new ExperienceRowMapper(), user_id);
    }

    @Override
    public int insertExperience(Experience experience, String companyName) {
        System.out.println(experience.title() + "\n\n\n\n\n\n");
        var sql = """
                INSERT INTO Experience (exp_ID, user_ID, title, description, type, start_date, end_date)
                VALUES (?, ?, ?, ?, 'WORK', ?, ?);
                """;
        jdbcTemplate.update(sql, experience.exp_ID(), experience.user_ID(), experience.title(), experience.description(), experience.start_date(), experience.end_date());


        sql = """
                SELECT company_ID FROM Company WHERE name = ?
                """;
        Optional<Company> temp = jdbcTemplate.query(sql, new CompanyRowMapper(), companyName).stream().findFirst();

        sql = """
                INSERT INTO Exp_company (exp_ID, user_ID, company_ID)
                VALUES (?, ?, ?);
                """;
        jdbcTemplate.update(sql, experience.exp_ID(), experience.user_ID(), temp.get().company_ID());

        sql = """
                INSERT INTO experiences (exp_ID, user_ID)
                VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, experience.exp_ID(), experience.user_ID());

    }

    @Override
    public int editExperience(Experience experience, String companyName) {
        var sql = """
                UPDATE Experience
                SET title = ?, description = ?, start_date = ?, end_date = ?
                WHERE exp_ID = ? AND user_ID = ? AND type != 'EDUCATION';
                UPDATE Exp_company
                SET company_ID = SELECT company_ID FROM Company WHERE name = ?
                WHERE exp_ID = ?;
                """;
        return jdbcTemplate.update(sql, experience.title(), experience.description(), experience.start_date(), experience.end_date(), experience.exp_ID(), experience.user_ID(), companyName, experience.exp_ID());
    }

    @Override
    public int deleteExperience(int exp_id, int user_id) {
        var sql = """
                DELETE FROM Experience
                WHERE exp_ID = ? AND user_ID = ? AND type != 'EDUCATION';
                DELETE FROM Exp_company
                WHERE exp_ID = ?;
                """;
        return jdbcTemplate.update(sql, exp_id, user_id, exp_id);
    }

    @Override
    public List<Experience> getEducations(int user_id) {
        var sql = """
                SELECT e.exp_ID AS exp_ID, e.name AS exp_name, e.title AS title,
                e.start_date AS start_date, e.end_date AS end_date, c.name AS
                company_name
                FROM (Experience NATURAL JOIN Exp_company) AS e JOIN Company
                AS c ON e.company_ID = c.company_ID
                WHERE user_ID = ? AND e.type = 'EDUCATION'
                """;
        return jdbcTemplate.query(sql, new ExperienceRowMapper(), user_id);
    }

    @Override
    public int insertEducation(Experience experience, String institution) {
        var sql = """
                INSERT INTO Experience (exp_ID, user_ID, title, description, type, start_date, end_date)
                VALUES (?, ?, ?, ?, 'EDUCATION', ?, ?);
                INSERT INTO Exp_company (exp_ID, company_ID)
                VALUES (?, SELECT company_ID FROM Company WHERE name = ?);
                """;
        return jdbcTemplate.update(sql, experience.exp_ID(), experience.user_ID(), experience.title(), experience.description(), experience.start_date(), experience.end_date(), experience.exp_ID(), institution);
    }

    @Override
    public int editEducation(Experience experience, String institution) {
        var sql = """
                UPDATE Experience
                SET title = ?, description = ?, start_date = ?, end_date = ?
                WHERE exp_ID = ? AND user_ID = ? AND type = 'EDUCATION';
                UPDATE Exp_company
                SET company_ID = SELECT company_ID FROM Company WHERE name = ?
                WHERE exp_ID = ?;
                """;
        return jdbcTemplate.update(sql, experience.title(), experience.description(), experience.start_date(), experience.end_date(), experience.exp_ID(), experience.user_ID(), institution, experience.exp_ID());
    }

    @Override
    public int deleteEducation(int exp_id, int user_id) {
        var sql = """
                DELETE FROM Experience
                WHERE exp_ID = ? AND user_ID = ? AND type = 'EDUCATION';
                DELETE FROM Exp_company
                WHERE exp_ID = ?;
                """;
        return jdbcTemplate.update(sql, exp_id, user_id, exp_id);
    }
}
