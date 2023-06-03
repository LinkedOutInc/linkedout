package app.linkedout.backend_v2.models;

import java.sql.Date;

public record Comment(Integer comment_ID, Integer post_ID, String content, Date date) {
}
