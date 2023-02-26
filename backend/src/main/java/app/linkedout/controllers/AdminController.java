package app.linkedout.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    // Currently just a placeholder.

    @GetMapping
    public String getAdminPanel() {
        return "Welcome to the Admin Panel.";
    }
}
