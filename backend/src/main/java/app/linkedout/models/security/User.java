package app.linkedout.models.security;

import app.linkedout.models.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
//@Table(name = "users",
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "email")
//        })
public class User extends BaseEntity {
    @Id
    private int userID;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userPassword;
    private String userResumeUrl; // URL
    private String jobTitle;
    private String location;
    private String role;
    private String userPictureUrl; // URL

    public User() {
        super();
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    @Size(max = 50)
//    @Email
//    private String email;
//
//    @NotBlank
//    @Size(max = 120)
//    private String password;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();
//
//    public User() {
//    }
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
}
