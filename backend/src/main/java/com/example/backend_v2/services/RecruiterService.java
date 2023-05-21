package com.example.backend_v2.services;

import com.example.backend_v2.dao.RecruiterDao;
import com.example.backend_v2.models.Recruiter;
import jakarta.el.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {

    private final RecruiterDao recruiterDao;

    public RecruiterService(RecruiterDao recruiterDao) {
        this.recruiterDao = recruiterDao;
    }

    public List<Recruiter> getRecruiters() {
        return recruiterDao.getRecruiters();
    }

    public void addRecruiter(Recruiter recruiter) {
        recruiterDao.insertRecruiter(recruiter);
    }

    public void deleteRecruiterById(int id) {
        recruiterDao.deleteRecruiterById(id);
    }

    public Recruiter getRecruiterById(int id) {
        return recruiterDao.getRecruiterById(id).orElseThrow(PropertyNotFoundException::new);
    }

    public Recruiter getRecruiterByEmail(String email) {
        return recruiterDao.getRecruiterByEmail(email).orElseThrow(PropertyNotFoundException::new);
    }
}
