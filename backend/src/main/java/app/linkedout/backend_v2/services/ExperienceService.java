package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.ExperienceDao;
import app.linkedout.backend_v2.models.Experience;
import app.linkedout.backend_v2.models.ExperienceAndCompany;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienceService {

    private final ExperienceDao experienceDao;

    public ExperienceService(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    public List<ExperienceAndCompany> getExperiences(int user_id) {
        return experienceDao.getExperiences(user_id);
    }

    public void addExperience(Experience experience, String companyName, int user_ID) {
        experienceDao.insertExperience(experience, companyName, user_ID);
    }

    public void editExperience(Experience experience, String companyName, int user_ID, int exp_ID) {
        experienceDao.editExperience(experience, companyName, user_ID, exp_ID);
    }

    public void deleteExperience(int exp_id, int user_id) {
        experienceDao.deleteExperience(exp_id, user_id);
    }

    public List<ExperienceAndCompany> getEducations(int user_id) {
        return experienceDao.getEducations(user_id);
    }

    public void addEducation(Experience experience, String companyName, int user_ID) {
        experienceDao.insertEducation(experience, companyName, user_ID);
    }

    public void editEducation(Experience experience, String companyName, int user_ID, int exp_ID) {
        experienceDao.editEducation(experience, companyName, user_ID, exp_ID);
    }

    public void deleteEducation(int exp_id, int user_id) {
        experienceDao.deleteEducation(exp_id, user_id);
    }
}
