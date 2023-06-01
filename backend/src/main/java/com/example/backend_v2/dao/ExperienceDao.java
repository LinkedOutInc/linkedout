package com.example.backend_v2.dao;

import com.example.backend_v2.models.Experience;
import com.example.backend_v2.models.ExperienceAndCompany;

import java.util.List;

public interface ExperienceDao {
    List<ExperienceAndCompany> getExperiences(int user_id);
    int insertExperience(Experience experience, String companyName);
    int editExperience(Experience experience, String companyName);
    int deleteExperience(int exp_id, int user_id);
    List<ExperienceAndCompany> getEducations(int user_id);
    int insertEducation(Experience experience, String institution);
    int editEducation(Experience experience, String institution);
    int deleteEducation(int exp_id, int user_id);
}
