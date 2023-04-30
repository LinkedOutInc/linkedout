package app.linkedout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reports extends BaseEntity {
    @Id
    private int adminID;
    @Id
    private int reportID;
}
