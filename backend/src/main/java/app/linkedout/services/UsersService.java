package app.linkedout.services;

import app.linkedout.models.Users;
import app.linkedout.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements CrudService<Users, Long> {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List findAll() {
        ArrayList<Users> ls = new ArrayList<>();
        usersRepository.findAll().forEach(ls::add);
        return ls;
    }

    @Override
    public Users findById(Long aLong) {
        return usersRepository.findById(aLong).orElse(null);
    }

    @Override
    public Users save(Users object) {
        return usersRepository.save(object);
    }

    @Override
    public void delete(Users object) {
        usersRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        usersRepository.deleteById(aLong);
    }

    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public List<Users> findBySurname(String surname) {
        return usersRepository.findBySurname(surname);
    }
}
