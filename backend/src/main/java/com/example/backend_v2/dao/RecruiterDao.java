package com.example.backend_v2.dao;

import com.example.backend_v2.models.Recruiter;

import java.util.List;
import java.util.Optional;

public interface RecruiterDao {
    List<Recruiter> getRecruiters();
    int insertRecruiter(Recruiter recruiter);
    int deleteRecruiterById(int id);
    Optional<Recruiter> getRecruiterById(int id);
    Optional<Recruiter> getRecruiterByEmail(String email);
}