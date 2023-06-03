package app.linkedout.backend_v2.models;

import java.sql.Date;
import java.time.LocalDateTime;

public record Comment(Integer comment_ID, Integer post_ID, String content, LocalDateTime date) {

    public Comment filter() {
        return new Comment(null, post_ID(), content(), LocalDateTime.now());
    }
}
