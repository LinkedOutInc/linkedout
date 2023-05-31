package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.dao.InterestDao;
import app.linkedout.backend_v2.models.Interest;
import app.linkedout.backend_v2.repositories.rowMappers.InterestRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InterestRepository implements InterestDao {

    private final JdbcTemplate jdbcTemplate;

    public InterestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Interest> getUserInterests(int user_id) {
        var sql = """
                SELECT *
                FROM Interest AS I
                WHERE I.id IN
                (SELECT int_id
                FROM Interests
                WHERE person_id = ?);
                """;
        return jdbcTemplate.query(sql, new InterestRowMapper(), user_id);
    }

    @Override
    public Optional<Interest> getInterestById(int id) {
        var sql  = """
                SELECT  *
                FROM Interest
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new InterestRowMapper(), id).stream().findFirst();
    }

    @Override
    public int insertInterest(Interest interest, int user_id) {
        var sql = """
                INSERT INTO Interest(title, area)
                VALUES(?, ?);
                """;
        jdbcTemplate.update(sql, interest.title(), interest.area());
        Interest newInterest = findInterestByTitle(interest.title()).orElseThrow();
        var map_sql = """
                INSERT INTO Interests(int_id, person_id)
                VALUES(?, ?);
                """;
        return jdbcTemplate.update(map_sql, newInterest.id(), user_id);
    }

    @Override
    public int deleteInterestById(int id) {
        var sql1 = """
                DELETE FROM Interest
                WHERE id = ?;
                """;
        var sql2 = """
                DELETE FROM Interests
                WHERE int_id = ?;
                """;
        jdbcTemplate.update(sql2, id);
        return jdbcTemplate.update(sql1, id);
    }

    @Override
    public int deleteInterest(Interest interest) {
        var sql1 = """
                DELETE FROM Interest
                WHERE id = ?;
                """;
        var sql2 = """
                DELETE FROM Interests
                WHERE int_id = ?;
                """;
        jdbcTemplate.update(sql2, interest.id());
        return jdbcTemplate.update(sql1, interest.id());
    }

    public Optional<Interest> findInterestByTitle(String title) {
        var sql = """
                SELECT * FROM Interest
                WHERE title = ?;
                """;
        return jdbcTemplate.query(sql, new InterestRowMapper(),title).stream().findFirst();
    }
}
