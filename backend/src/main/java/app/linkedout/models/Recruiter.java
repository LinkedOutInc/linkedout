package app.linkedout.models;

import app.linkedout.models.security.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Recruiter extends User {
    private boolean isHiring;
}
