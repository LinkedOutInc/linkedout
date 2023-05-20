package com.example.backend_v2.controllers;

import com.example.backend_v2.models.Person;
import com.example.backend_v2.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public void insertPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personService.deletePersonById(id);
    }
}