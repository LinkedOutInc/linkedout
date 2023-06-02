package app.linkedout.backend_v2.models;

import java.sql.Date;

public record File (Integer file_id, Integer user_id, String content, String fileName, String fileType, Date uploadTime, String contentType) {

}
