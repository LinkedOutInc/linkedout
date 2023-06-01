package app.linkedout.backend_v2.models;

import java.sql.Blob;
import java.sql.Date;

public record JobPostAndCompany(Integer post_ID, Date date, String content, String job_title, Integer company_ID, String workplace, String position, String profession, String name, String location, String about, String domain, Blob company_picture) {
}
