package com.example.backend_v2.models;

import java.sql.Date;

public record JobPost(Integer post_ID, Date date, String content, String job_title, Integer company_ID, String workplace, String position, String profession) {
}
