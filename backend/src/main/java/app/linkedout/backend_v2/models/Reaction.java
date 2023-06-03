package app.linkedout.backend_v2.models;

import java.sql.Date;

public record Reaction(Integer reaction_ID, String type, Date date) {
}
