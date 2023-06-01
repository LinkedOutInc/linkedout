package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    List<Person> getPersons();
    int insertPerson(Person person);
    int deletePersonById(int id);
    Optional<Person> getPersonById(int id);
    Optional<Person> getPersonByEmail(String email);
}
