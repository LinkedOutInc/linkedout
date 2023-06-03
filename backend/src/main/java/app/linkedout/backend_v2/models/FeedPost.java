package app.linkedout.backend_v2.models;

import java.sql.Date;

public record FeedPost(Integer post_ID, String title, Date date, String content, String image, String type) {
}
