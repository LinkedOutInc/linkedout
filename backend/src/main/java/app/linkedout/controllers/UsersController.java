package app.linkedout.controllers;

import app.linkedout.models.Person;
import app.linkedout.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;}

    @GetMapping
    public ResponseEntity<List<Person>> getAllUsers() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getUsersById(@PathVariable String id) {
        return new ResponseEntity<>(usersService.findById(Long.valueOf(id)), HttpStatus.OK);
    }
}
