package app.linkedout.services;

import app.linkedout.models.Person;
import app.linkedout.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements CrudService<Person, Long> {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List findAll() {
        ArrayList<Person> ls = new ArrayList<>();
        personRepository.findAll().forEach(ls::add);
        return ls;
    }

    @Override
    public Person findById(Long aLong) {
        return personRepository.findById(aLong).orElse(null);
    }

    @Override
    public Person save(Person object) {
        return personRepository.save(object);
    }

    @Override
    public void delete(Person object) {
        personRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        personRepository.deleteById(aLong);
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public List<Person> findBySurname(String surname) {
        return personRepository.findBySurname(surname);
    }
}
