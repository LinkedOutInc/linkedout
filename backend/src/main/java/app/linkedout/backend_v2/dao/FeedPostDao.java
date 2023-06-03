package app.linkedout.backend_v2.dao;

import java.util.HashMap;
import java.util.List;

public interface FeedPostDao {
    public List<HashMap<String, Object>> getFeed(int offset, int limit);
}