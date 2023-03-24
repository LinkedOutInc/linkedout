package app.linkedout.services;

import app.linkedout.models.Person;
import app.linkedout.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements CrudService<Person, Long> {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List findAll() {
        ArrayList<Person> ls = new ArrayList<>();
        usersRepository.findAll().forEach(ls::add);
        return ls;
    }

    @Override
    public Person findById(Long aLong) {
        return usersRepository.findById(aLong).orElse(null);
    }

    @Override
    public Person save(Person object) {
        return usersRepository.save(object);
    }

    @Override
    public void delete(Person object) {
        usersRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        usersRepository.deleteById(aLong);
    }

    public Person findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public List<Person> findBySurname(String surname) {
        return usersRepository.findBySurname(surname);
    }
}
