package app.linkedout.services;

import app.linkedout.models.Admin;
import app.linkedout.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements CrudService<Admin, Long> {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List findAll() {
        ArrayList<Admin> ls = new ArrayList<>();
        adminRepository.findAll().forEach(ls::add);
        return ls;
    }

    @Override
    public Admin findById(Long aLong) {
        return adminRepository.findById(aLong).orElse(null);
    }

    @Override
    public Admin save(Admin object) {
        return adminRepository.save(object);
    }

    @Override
    public void delete(Admin object) {
        adminRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        adminRepository.deleteById(aLong);
    }

}
