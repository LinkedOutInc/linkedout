package app.linkedout.backend_v2.dao;

import java.util.HashMap;
import java.util.List;

public interface ReactionDao {
    public Object getReactionId(String reactionType);
    public Object getUserReactionList(int postId, int userId);
    public Object insertUserReaction(int postId, int reactionId, int userId);
    public Object updateUserReaction(int postId, int reactionId, int userId);
    public List<HashMap<String, Object>> getReactionCounts(int postId);
    public Object removeUserReaction(int postId, int userId);
    public Object removeUserReactions(int postId);
}