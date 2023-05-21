package com.example.backend_v2.services;

import com.example.backend_v2.dao.PersonDao;
import com.example.backend_v2.models.Person;
import jakarta.el.PropertyNotFoundException;
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

    public Person getPersonById(int id) {
        return personDao.getPersonById(id).orElseThrow(PropertyNotFoundException::new);
    }

    public Person getPersonByEmail(String email) {
        return personDao.getPersonByEmail(email).orElseThrow(PropertyNotFoundException::new);
    }
}

