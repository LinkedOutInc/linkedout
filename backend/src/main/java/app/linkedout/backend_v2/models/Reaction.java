package app.linkedout.backend_v2.models;

import java.sql.Date;
import java.time.LocalDateTime;

public record Reaction(Integer reaction_ID, String type, LocalDateTime date) {

    public Reaction filter() {
        return new Reaction(null, type(), LocalDateTime.now());
    }
}
