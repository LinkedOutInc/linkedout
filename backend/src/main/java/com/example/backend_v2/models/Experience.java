package com.example.backend_v2.models;

import java.sql.Date;

public record Experience(Integer exp_id, Integer user_id, String title, String description, String type, Date start_date, Date end_date) {
}
