package app.linkedout.backend_v2.models;

import java.sql.Date;
import java.time.LocalDateTime;

public record FeedPost(Integer post_ID, String title, LocalDateTime date, String content, String image, String type) {
    public FeedPost filter() {
        return new FeedPost(null, title(), LocalDateTime.now(), content(), image(), type());
    }
}
