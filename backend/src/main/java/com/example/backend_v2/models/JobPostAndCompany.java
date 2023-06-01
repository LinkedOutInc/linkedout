package com.example.backend_v2.models;

import java.sql.Blob;
import java.sql.Date;

public record JobPostAndCompany(Integer post_id, Date date, String content, String job_title, Integer company_id, String workplace, String location, String position, String profession, String name, String about, String domain, Blob company_picture) {
}
