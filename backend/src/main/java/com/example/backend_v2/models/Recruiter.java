package com.example.backend_v2.models;

public record Recruiter(Integer id, String name, String surname, String email, String password, String job_title, String location, String role, boolean is_hiring) {
}
