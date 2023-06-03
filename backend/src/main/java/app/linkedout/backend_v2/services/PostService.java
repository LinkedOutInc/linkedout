package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.FeedPostDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.models.FeedPost;
import app.linkedout.backend_v2.models.Recruiter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PostService {

    private final FeedPostDao feedPostDao;

    public PostService(FeedPostDao feedPostDao) {
        this.feedPostDao = feedPostDao;
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
}
