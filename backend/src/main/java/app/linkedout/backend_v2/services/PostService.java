package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.FeedPostDao;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final FeedPostDao feedPostDao;

    public PostService(FeedPostDao feedPostDao) {
        this.feedPostDao = feedPostDao;
    }

}
