package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final SessionService sessionService;

    @GetMapping
    public ResponseEntity<Object> getProfile() throws Exception {
        return ResponseEntity.ok().body(sessionService.getCurrentUser());
    }

}
