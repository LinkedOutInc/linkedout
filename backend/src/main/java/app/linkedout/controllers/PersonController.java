package app.linkedout.controllers;

import app.linkedout.models.Person;
import app.linkedout.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;}

    @GetMapping
    public ResponseEntity<List<Person>> getAllUsers() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getUsersById(@PathVariable String id) {
        return new ResponseEntity<>(personService.findById(Long.valueOf(id)), HttpStatus.OK);
    }
}
