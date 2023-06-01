package app.linkedout.backend_v2.models;

import java.sql.Date;

public record Experience(Integer exp_ID, Integer user_ID, String title, String description, String type, Date start_date, Date end_date) {
}
