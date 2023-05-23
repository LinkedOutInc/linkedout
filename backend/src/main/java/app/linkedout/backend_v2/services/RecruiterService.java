package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.RecruiterDao;
import app.linkedout.backend_v2.models.Recruiter;
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

    public Recruiter getRecruiterById(int id) throws Exception {
        return recruiterDao.getRecruiterById(id).orElseThrow(Exception::new);
    }

    public Recruiter getRecruiterByEmail(String email) throws Exception {
        return recruiterDao.getRecruiterByEmail(email).orElseThrow(Exception::new);
    }
}
