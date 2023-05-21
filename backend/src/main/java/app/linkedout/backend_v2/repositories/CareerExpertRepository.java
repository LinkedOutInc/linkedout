package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.CareerExpertDao;
import app.linkedout.backend_v2.repositories.rowMappers.CareerExpertRowMapper;
import app.linkedout.backend_v2.models.CareerExpert;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CareerExpertRepository implements CareerExpertDao {

    private final JdbcTemplate jdbcTemplate;

    public CareerExpertRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CareerExpert> getCareerExperts() {
        var sql = """
                SELECT *
                FROM CareerExpert
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new CareerExpertRowMapper());
    }

    @Override
    public int insertCareerExpert(CareerExpert careerExpert) {
        var sql = """
                INSERT INTO CareerExpert(name, surname, email, password, job_title, location, role, field)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, careerExpert.name(), careerExpert.surname(), careerExpert.email(), careerExpert.password(), careerExpert.job_title(), careerExpert.location(), careerExpert.role(), careerExpert.field());
    }

    @Override
    public int deleteCareerExpertById(int id) {
        var sql = """
                DELETE FROM CareerExpert
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<CareerExpert> getCareerExpertById(int id) {
        var sql = """
                SELECT  * FROM CareerExpert
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new CareerExpertRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<CareerExpert> getCareerExpertByEmail(String email) {
        var sql = """
                SELECT * FROM CareerExpert
                WHERE email='?';
                """;
        return jdbcTemplate.query(sql, new CareerExpertRowMapper(), email).stream().findFirst();
    }
}
