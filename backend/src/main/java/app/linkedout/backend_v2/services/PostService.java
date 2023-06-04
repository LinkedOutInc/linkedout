package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.CommentDao;
import app.linkedout.backend_v2.dao.FeedPostDao;
import app.linkedout.backend_v2.dao.ReactionDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PostService {

    private final FeedPostDao feedPostDao;
    private final CommentDao commentDao;
    private final ReactionDao reactionDao;

    public PostService(FeedPostDao feedPostDao, CommentDao commentDao, ReactionDao reactionDao) {
        this.feedPostDao = feedPostDao;
        this.commentDao = commentDao;
        this.reactionDao = reactionDao;
    }

    public List<HashMap<String, Object>> getFeed(int userId, int offset) {
        return feedPostDao.getFeed(userId, offset);
    }

    public Object newPost(int userId, FeedPost feedPost) {
        feedPost = feedPost.filter();

        return feedPostDao.insertPost(userId, feedPost);
    }

    public Object deletePost(int userId, int postId) {
        Object queryResult = feedPostDao.getPost(postId);
        if (queryResult instanceof ResponseEntity<?>) {
            return queryResult;
        }

        HashMap<String, Object> feedPost = (HashMap<String, Object>) queryResult;
        int ownerId = (int) ((long) feedPost.get("user_id"));

        if (ownerId != userId) {
            return Error.create(403, "Not authorized to delete post of another user.");
        }

        return feedPostDao.deletePost(postId);
    }

    public List<HashMap<String, Object>> getComments(int postId, int offset) {
        return commentDao.getComments(postId, offset);
    }

    public Object newComment(int postId, Comment comment, int userId) {
        comment = comment.filter(postId);

        // Check if post exists
        Object queryResult = feedPostDao.getPost(postId);
        if (queryResult instanceof ResponseEntity<?>) {
            return queryResult;
        }

        return commentDao.insertComment(comment, userId);
    }

    public Object deleteComment(int postId, int commentId, int userId) {
        // Check if post exists
        Object queryResult = feedPostDao.getPost(postId);
        if (queryResult instanceof ResponseEntity<?>) {
            return queryResult;
        }

        // Check comment owner
        queryResult = commentDao.getComment(commentId);
        if (queryResult instanceof ResponseEntity<?>) {
            return queryResult;
        }

        HashMap<String, Object> comment = (HashMap<String, Object>) queryResult;
        int ownerId = (int) ((long) comment.get("user_id"));

        if (ownerId != userId) {
            return Error.create(403, "Not authorized to delete comment of another user.");
        }

        return commentDao.deleteComment(commentId);
    }

    public Object updateReaction(int postId, String reactionType, int userId) {
        // Check if post exists
        Object queryResult = feedPostDao.getPost(postId);
        if (queryResult instanceof ResponseEntity<?>) {
            return queryResult;
        }

        // Get reaction id
        queryResult = reactionDao.getReactionId(reactionType);
        if (queryResult instanceof ResponseEntity<?>) {
            return queryResult;
        }

        int reactionId = (int) queryResult;

        // Check if reaction exists
        queryResult = reactionDao.getUserReactionList(postId, userId);
        if (queryResult instanceof ResponseEntity<?>) {
            return queryResult;
        }

        List<UserReaction> tempUserReactions = (List<UserReaction>) queryResult;
        if (tempUserReactions.isEmpty()) {
            // Insert
            return reactionDao.insertUserReaction(postId, reactionId, userId);
        }

        // Update
        return reactionDao.updateUserReaction(postId, reactionId, userId);
    }
}
