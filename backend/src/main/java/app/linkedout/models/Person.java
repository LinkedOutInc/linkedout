package app.linkedout.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person extends BaseEntity {
    private String jobTitle;
}