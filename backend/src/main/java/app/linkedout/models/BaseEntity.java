package app.linkedout.models;

import app.linkedout.models.security.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    private HashMap<String, Object> extraProperties;

    protected BaseEntity() {
        extraProperties = new HashMap<>();
    }

    Object get(String key) {
        return extraProperties.getOrDefault(key, null);
    }

    void set(String key, Object val) {
        extraProperties.put(key, val);
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String surname;
//    private String password;
//    private String email;
}

