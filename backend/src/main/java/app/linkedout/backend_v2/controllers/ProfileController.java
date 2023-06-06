package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.models.Interest;
import app.linkedout.backend_v2.models.Person;
import app.linkedout.backend_v2.services.InterestService;
import app.linkedout.backend_v2.services.PersonService;
import app.linkedout.backend_v2.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final SessionService sessionService;
    private final InterestService interestService;
    private final PersonService personService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<Object> getProfile() throws Exception {
        return ResponseEntity.ok().body(sessionService.getCurrentUser());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("updateImage")
    public Object updateImage(@RequestBody HashMap<String, Object> body) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        if (body.get("link") == null) {
            return Error.create(400, "'link' not found in the body.");
        }

        int userId = (int) controlResult;
        return personService.updateImage(userId, (String) body.get("link"));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("updateResume")
    public Object updateResume(@RequestBody HashMap<String, Object> body) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        if (body.get("link") == null) {
            return Error.create(400, "'link' not found in the body.");
        }

        int userId = (int) controlResult;
        return personService.updateResume(userId, (String) body.get("link"));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/interests")
    public ResponseEntity<List<Interest>> getInterests() throws Exception {
        int userId = sessionService.getCurrentUserId();
        ArrayList<Interest> interests = (ArrayList<Interest>) interestService.getUserInterests(userId);
        return ResponseEntity.ok().body(interests);
    }



    @CrossOrigin(origins = "*")
    @PostMapping("/interests/add")
    public void addInterest(@RequestBody Interest interest) throws Exception {
        interestService.insertInterest(interest, sessionService.getCurrentUserId());
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/interests/delete/{id}")
    public void deleteInterest(@PathVariable("id") Integer id) {
        interestService.deleteInterestById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/edit")
    public void editProfile(@RequestBody Person person) throws Exception {
        int id = sessionService.getCurrentUserId();
        personService.editProfile(person, id);
    }
}
