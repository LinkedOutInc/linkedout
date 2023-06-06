package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.PersonDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.dto.Success;
import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.repositories.rowMappers.PersonRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getPersons() {
        var sql = """
                SELECT *
                FROM Person
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    @Override
    public int insertPerson(Person person) {
        var sql = """
                INSERT INTO Person(name, surname, email, password, job_title, location, role)
                VALUES(?, ?, ?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, person.name(), person.surname(), person.email(), person.password(), person.job_title(), person.location(), person.role());
    }

    @Override
    public int deletePersonById(int id) {
        var sql = """
                DELETE FROM Person
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        var sql = """
                SELECT * FROM Person
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new PersonRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<Person> getPersonByEmail(String email) {
        var sql = """
                SELECT * FROM Person
                WHERE email = ?;
                """;
        return jdbcTemplate.query(sql, new PersonRowMapper(), email).stream().findFirst();
    }

    @Override
    public Object updateImage(int userId, String link) {
        var sql = """
                UPDATE Person
                SET image = ?
                WHERE id = ?;
                """;
        int queryResult = jdbcTemplate.update(sql, link, userId);
        if (queryResult <= 0) {
            return Error.create(500, "Image could not be updated.");
        }
        return Success.create("Image updated.");
    }

    @Override
    public Object updateResume(int userId, String link) {
        var sql = """
                UPDATE Person
                SET resume = ?
                WHERE id = ?;
                """;
        int queryResult = jdbcTemplate.update(sql, link, userId);
        if (queryResult <= 0) {
            return Error.create(500, "Resume could not be updated.");
        }
        return Success.create("Resume updated.");
    }

    @Override
    public void editProfile(Person person, int userId) {
        var sql = """
                UPDATE Person
                SET name = ?, surname = ?, email = ?, password = ?, job_title = ?, location = ?, image = ?, resume = ?
                WHERE id = ?;
                """;
        jdbcTemplate.update(sql, person.name(), person.surname(), person.email(), person.password(), person.job_title(), person.location(), person.image(), person.resume(), userId);
    }
}
