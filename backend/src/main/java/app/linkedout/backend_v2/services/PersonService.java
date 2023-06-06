package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.PersonDao;
import app.linkedout.backend_v2.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getPersons() {
        return personDao.getPersons();
    }

    public void addPerson(Person person) {
        personDao.insertPerson(person);
    }

    public void deletePersonById(int id) {
        personDao.deletePersonById(id);
    }

    public Person getPersonById(int id) throws Exception {
        return personDao.getPersonById(id).orElseThrow(Exception::new);
    }

    public Person getPersonByEmail(String email) throws Exception {
        return personDao.getPersonByEmail(email).orElseThrow(Exception::new);
    }

    public Object updateImage(int userId, String link) {
        return personDao.updateImage(userId, link);
    }

    public Object updateResume(int userId, String link) {
        return personDao.updateResume(userId, link);
    }

    public void editProfile(Person person, int userId) {
        personDao.editProfile(person, userId);
    }
}

