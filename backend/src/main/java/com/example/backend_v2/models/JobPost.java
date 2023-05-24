package com.example.backend_v2.models;

import java.sql.Date;

public record JobPost(Integer post_id, Date date, String content, String job_title, Integer company_id, String workplace, String location, String position, String profession) {
}
