package app.linkedout.repositories;

import app.linkedout.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Person, Long> {

    /*
    * Additional find methods added for extra functionality.
    * findByEmail(String email): Finds a user by a given email.
    * findBySurname(String surname): Finds all users with the given surname.
    * */
    Person findByEmail(String email);
    List<Person> findBySurname(String surname);
}
