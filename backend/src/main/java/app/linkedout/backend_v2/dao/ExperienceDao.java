package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.Experience;
import app.linkedout.backend_v2.models.ExperienceAndCompany;

import java.util.List;

public interface ExperienceDao {
    List<ExperienceAndCompany> getExperiences(int user_id);
    int insertExperience(Experience experience, String companyName, int user_ID);
    int editExperience(Experience experience, String companyName, int user_ID, int exp_ID);
    int deleteExperience(int exp_id, int user_id);
    List<ExperienceAndCompany> getEducations(int user_id);
    int insertEducation(Experience experience, String institution, int user_ID);
    int editEducation(Experience experience, String institution, int user_ID, int exp_ID);
    int deleteEducation(int exp_id, int user_id);
}
