package app.linkedout.backend_v2.repositories;

import app.linkedout.backend_v2.models.Person;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    private final PersonRepository personRepository;

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "cemg@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "user.mail@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public UserDetails findUserByEmail(String email) {
        Person person = personRepository.getPersonByEmail(email).orElse(null);
        User user = new User(
          person.email(), person.password(), Collections.singleton(new SimpleGrantedAuthority(person.role())
        ));
        return user;
    }
}
