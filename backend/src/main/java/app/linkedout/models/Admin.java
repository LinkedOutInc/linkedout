package app.linkedout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin extends BaseEntity {
    @Id
    private int adminID;
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;

//    private String secret;
}
