package app.linkedout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Applies extends BaseEntity {
    @Id
    private int userID;
    @Id
    private int postID;
}
