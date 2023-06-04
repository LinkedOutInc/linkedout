package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.Comment;

import java.util.HashMap;
import java.util.List;

public interface CommentDao {
    public List<HashMap<String, Object>> getComments(int postId, int offset);
    public Object insertComment(Comment comment, int userId);
    public Object getComment(int commentId);
    public Object deleteComment(int commentId);
}