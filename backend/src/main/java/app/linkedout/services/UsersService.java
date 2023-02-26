package app.linkedout.services;

import app.linkedout.models.Users;
import app.linkedout.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements CrudService {

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
    public Object findById(Object o) {
        return null;
    }

    @Override
    public Object save(Object object) {
        return null;
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void deleteById(Object o) {

    }
}
