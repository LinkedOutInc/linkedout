package app.linkedout.models;

import app.linkedout.models.security.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CareerExpert extends User {
    private String field;
}
