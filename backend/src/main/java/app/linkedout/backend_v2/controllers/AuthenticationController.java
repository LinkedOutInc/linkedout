package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.config.JwtUtils;
import app.linkedout.backend_v2.dto.AuthenticationRequest;
import app.linkedout.backend_v2.models.CareerExpert;
import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.models.Recruiter;
import app.linkedout.backend_v2.repositories.UserRepository;
import app.linkedout.backend_v2.services.CareerExpertService;
import app.linkedout.backend_v2.services.PersonService;
import app.linkedout.backend_v2.services.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PersonService personService;
    private final RecruiterService recruiterService;
    private final CareerExpertService careerExpertService;

    @CrossOrigin(origins = "*")
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate (@RequestBody AuthenticationRequest request) {

        Person usr;

        try {
            usr = personService.getPersonByEmail(request.getEmail());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("[-] Error extracting user with email: " + request.getEmail());
        }

        if(usr==null) {
            return ResponseEntity.status(400).body("[-] Could not find user with email: " + request.getEmail());
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails user = userRepository.findUserByEmail(request.getEmail());
        if(user!=null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("[-] Error during authentication.");
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody Person person) {

        // TODO: Add Different Register for different users!!!

        if(Objects.equals(person.role(), "ROLE_USER")) {
            personService.addPerson(person);
        }
        else if(Objects.equals(person.role(), "ROLE_RECRUITER")) {
            recruiterService.addRecruiter(new Recruiter(person.id(), person.name(), person.surname(), person.email(), person.password(), person.job_title(), person.image(), person.location(), person.role(), false));
        }
        else if(Objects.equals(person.role(), "ROLE_CE")) {
            careerExpertService.addCareerExpert(new CareerExpert(person.id(), person.name(), person.surname(), person.email(), person.password(), person.job_title(), person.location(), person.image(), person.role(), "dummy"));
        }
        else {
            return ResponseEntity.badRequest().body("[-] User could not be registered.");
        }

        return ResponseEntity.ok("User successfully registered.");
    }
}
