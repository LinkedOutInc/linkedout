package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.services.CareerExpertService;
import app.linkedout.backend_v2.services.PersonService;
import app.linkedout.backend_v2.services.RecruiterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final PersonService personService;
    private final CareerExpertService careerExpertService;
    private final RecruiterService recruiterService;

    public LoginController(PersonService personService, CareerExpertService careerExpertService, RecruiterService recruiterService) {
        this.personService = personService;
        this.careerExpertService = careerExpertService;
        this.recruiterService = recruiterService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody HashMap<String, Object> payload) {
        String email = "", password = "";
        try {
            email = (String) payload.get("email");
            password = (String) payload.get("password");
        } catch (Exception e) {
            System.out.println("[-] Invalid request body.");}

        System.out.println("===> " + email + " " + password);

        Person usr = personService.getPersonByEmail(email);

        if(usr == null) {
            return ResponseEntity.status(401).body("User does not exist!");
        }
        System.out.println("===> " + usr.email() + " " + usr.password());
        if(Objects.equals(usr.password(), password)) {
            return ResponseEntity.status(200).body(usr);
        }
        return ResponseEntity.status(401).body("Login Unsuccessful.");
    }
}
