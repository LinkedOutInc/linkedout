package app.linkedout.backend_v2.models;

public record Recruiter(Integer id, String name, String surname, String email, String password, String job_title, String location, String image, String role, boolean is_hiring) {
}
