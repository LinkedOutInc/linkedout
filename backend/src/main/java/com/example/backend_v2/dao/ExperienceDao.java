package com.example.backend_v2.dao;

import com.example.backend_v2.models.Experience;

import java.util.List;

public interface ExperienceDao {
    List<Experience> getExperiences(int user_id);
    int insertExperience(Experience experience, String companyName);
    int editExperience(Experience experience, String companyName);
    int deleteExperience(int exp_id, int user_id);
    List<Experience> getEducations(int user_id);
    int insertEducation(Experience experience, String institution);
    int editEducation(Experience experience, String institution);
    int deleteEducation(int exp_id, int user_id);
}
