package app.linkedout.models.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// TODO: Delete?

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumRole name;

    public void setByString(String s) {
        if(s.equals("ROLE_USER")) {
            name = EnumRole.ROLE_USER;
        }
        else if(s.equals("ROLE_RECRUITER")) {
            name = EnumRole.ROLE_RECRUITER;
        }
        else if(s.equals("ROLE_CE")) {
            name = EnumRole.ROLE_CE;
        }
        else if(s.equals("ROLE_ADMIN")) {
            name = EnumRole.ROLE_ADMIN;
        }

    }
}
