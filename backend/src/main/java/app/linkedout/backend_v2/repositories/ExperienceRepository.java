package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.ExperienceDao;
import app.linkedout.backend_v2.models.Company;
import app.linkedout.backend_v2.models.Experience;
import app.linkedout.backend_v2.models.ExperienceAndCompany;
import app.linkedout.backend_v2.repositories.rowMappers.CompanyRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.ExperienceAndCompanyRowMapper;
import app.linkedout.backend_v2.repositories.rowMappers.ExperienceRowMapper;
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
    public List<ExperienceAndCompany> getExperiences(int user_id) {
        var sql = """
                SELECT *
                FROM (Experience NATURAL JOIN Exp_company) AS e JOIN Company
                AS c ON e.company_ID = c.company_ID
                WHERE e.user_ID = ? AND e.type != 'EDUCATION'
                """;
        return jdbcTemplate.query(sql, new ExperienceAndCompanyRowMapper(), user_id);
    }

    @Override
    public int insertExperience(Experience experience, String companyName) {
        var sql = """
                INSERT INTO Experience (exp_ID, user_ID, title, description, type, start_date, end_date)
                VALUES (?, ?, ?, ?, 'WORK', ?, ?);
                """;
        jdbcTemplate.update(sql, experience.exp_ID(), experience.user_ID(), experience.title(), experience.description(), experience.start_date(), experience.end_date());


        sql = """
                SELECT * FROM Company WHERE name = ?
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
                SELECT * FROM Company WHERE name = ?
                """;
        Optional<Company> temp = jdbcTemplate.query(sql, new CompanyRowMapper(), companyName).stream().findFirst();

        sql = """
                UPDATE Experience
                SET title = ?, description = ?, start_date = ?, end_date = ?
                WHERE exp_ID = ? AND user_ID = ? AND type != 'EDUCATION';
                UPDATE Exp_company
                SET company_ID = ?
                WHERE exp_ID = ?;
                """;
        return jdbcTemplate.update(sql, experience.title(), experience.description(), experience.start_date(), experience.end_date(), experience.exp_ID(), experience.user_ID(), temp.get().company_ID(), experience.exp_ID());
    }

    @Override
    public int deleteExperience(int exp_id, int user_id) {
        var sql = """
                SELECT * FROM Experience
                WHERE exp_ID = ? AND user_ID = ?;
                """;
        Optional<Experience> experience = jdbcTemplate.query(sql, new ExperienceRowMapper(), exp_id, user_id).stream().findFirst();
        if(experience.isPresent() && experience.get().type().equals("EDUCATION")) {
            return -1;
        }
        sql = """
                DELETE FROM Exp_company
                WHERE exp_ID = ?;
                DELETE FROM experiences
                WHERE exp_ID = ?;
                DELETE FROM Experience
                WHERE exp_ID = ? AND user_ID = ? AND type != 'EDUCATION';
                """;
        return jdbcTemplate.update(sql, exp_id, exp_id, exp_id, user_id);
    }

    @Override
    public List<ExperienceAndCompany> getEducations(int user_id) {
        var sql = """
                SELECT *
                FROM (Experience NATURAL JOIN Exp_company) AS e JOIN Company
                AS c ON e.company_ID = c.company_ID
                WHERE e.user_ID = ? AND e.type = 'EDUCATION'
                """;
        return jdbcTemplate.query(sql, new ExperienceAndCompanyRowMapper(), user_id);
    }

    @Override
    public int insertEducation(Experience experience, String institution) {
        var sql = """
                INSERT INTO Experience (exp_ID, user_ID, title, description, type, start_date, end_date)
                VALUES (?, ?, ?, ?, 'EDUCATION', ?, ?);
                """;
        jdbcTemplate.update(sql, experience.exp_ID(), experience.user_ID(), experience.title(), experience.description(), experience.start_date(), experience.end_date());


        sql = """
                SELECT * FROM Company WHERE name = ?
                """;
        Optional<Company> temp = jdbcTemplate.query(sql, new CompanyRowMapper(), institution).stream().findFirst();

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
    public int editEducation(Experience experience, String institution) {
        var sql = """
                SELECT * FROM Company WHERE name = ?
                """;
        Optional<Company> temp = jdbcTemplate.query(sql, new CompanyRowMapper(), institution).stream().findFirst();

        sql = """
                UPDATE Experience
                SET title = ?, description = ?, start_date = ?, end_date = ?
                WHERE exp_ID = ? AND user_ID = ? AND type = 'EDUCATION';
                UPDATE Exp_company
                SET company_ID = ?
                WHERE exp_ID = ?;
                """;
        return jdbcTemplate.update(sql, experience.title(), experience.description(), experience.start_date(), experience.end_date(), experience.exp_ID(), experience.user_ID(), temp.get().company_ID(), experience.exp_ID());
    }

    @Override
    public int deleteEducation(int exp_id, int user_id) {
        var sql = """
                SELECT * FROM Experience
                WHERE exp_ID = ? AND user_ID = ?;
                """;
        Optional<Experience> experience = jdbcTemplate.query(sql, new ExperienceRowMapper(), exp_id, user_id).stream().findFirst();
        if(experience.isPresent() && !experience.get().type().equals("EDUCATION")) {
            return -1;
        }
        sql = """
                DELETE FROM Exp_company
                WHERE exp_ID = ?;
                DELETE FROM experiences
                WHERE exp_ID = ?;
                DELETE FROM Experience
                WHERE exp_ID = ? AND user_ID = ? AND type = 'EDUCATION';
                """;
        return jdbcTemplate.update(sql, exp_id, exp_id, exp_id, user_id);
    }
}
