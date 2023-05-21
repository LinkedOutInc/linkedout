package com.example.backend_v2.repositories;

import com.example.backend_v2.dao.PersonDao;
import com.example.backend_v2.models.Person;
import com.example.backend_v2.repositories.rowMappers.PersonRowMapper;
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
                SELECT FROM Person
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new PersonRowMapper()).stream().findFirst();
    }
}
