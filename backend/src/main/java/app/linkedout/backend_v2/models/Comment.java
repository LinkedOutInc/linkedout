package app.linkedout.backend_v2.models;

import java.sql.Date;
import java.time.LocalDateTime;

public record Comment(Integer comment_ID, Integer post_ID, String content, LocalDateTime date) {

    public Comment filter(int postId) {
        return new Comment(null, postId, content(), LocalDateTime.now());
    }
}
