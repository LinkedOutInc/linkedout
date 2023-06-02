package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{id}")
    public Person getPersonById(@PathVariable("id") Integer id) throws Exception {
        return personService.getPersonById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personService.deletePersonById(id);
    }
}