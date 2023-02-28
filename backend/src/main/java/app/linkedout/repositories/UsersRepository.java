package app.linkedout.repositories;

import app.linkedout.models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {

    /*
    * Additional find methods added for extra functionality.
    * findByEmail(String email): Finds a user by a given email.
    * findBySurname(String surname): Finds all users with the given surname.
    * */
    Users findByEmail(String email);
    List<Users> findBySurname(String surname);
}
