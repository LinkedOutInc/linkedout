package com.example.backend_v2.models;

import java.sql.Blob;
import java.sql.Date;

public record ExperienceAndCompany(Integer exp_ID, Integer user_ID, String title, String description, String type, Date start_date, Date end_date, Integer company_ID, String name, String location, String about, String domain, Blob company_picture) {
}
