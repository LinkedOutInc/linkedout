package app.linkedout.backend_v2.dao;

import java.util.HashMap;
import java.util.List;

public interface CommentDao {
    public List<HashMap<String, Object>> getComments(int postId, int offset);
}