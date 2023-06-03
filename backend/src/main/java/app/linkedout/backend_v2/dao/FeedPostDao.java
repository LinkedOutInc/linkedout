package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.FeedPost;

import java.util.HashMap;
import java.util.List;

public interface FeedPostDao {
    public List<HashMap<String, Object>> getFeed(int offset, int limit);
    public Object insertPost(int userId, FeedPost feedPost);
    public Object getPost(int postId);
    public Object deletePost(int postId);
}