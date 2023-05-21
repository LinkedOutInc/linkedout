package com.example.backend_v2.controllers;

import com.example.backend_v2.models.Person;
import com.example.backend_v2.services.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final PersonService personService;

    public LoginController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void login(@RequestBody HashMap<String, Object> payload) {
        String email = "", password = "";
        try {
            email = (String) payload.get("email");
            password = (String) payload.get("password");
        } catch (Exception e) {
            System.out.println("[-] Invalid request body.");}



    }
}
