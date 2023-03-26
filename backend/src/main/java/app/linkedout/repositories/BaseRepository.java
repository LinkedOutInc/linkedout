package app.linkedout.repositories;

import java.util.List;

public class BaseRepository {

    protected String tableName;
    //    private final JdbcTemplate jdbcTemplate;

    protected void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void save(Object role) {

    }

    public int insert(Object role) {
        return 0;
    }

    public int update(Object role) {
        return 0;
    }

    public List<Object> select(Object role) {
        return null;
    }

    public int delete(Object role) {
        return 0;
    }
}
