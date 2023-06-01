package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.Interest;
import app.linkedout.backend_v2.services.InterestService;
import app.linkedout.backend_v2.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final SessionService sessionService;
    private final InterestService interestService;

    @GetMapping
    public ResponseEntity<Object> getProfile() throws Exception {
        return ResponseEntity.ok().body(sessionService.getCurrentUser());
    }

    @GetMapping("/interests")
    public ResponseEntity<List<Interest>> getInterests() throws Exception {
        int userId = sessionService.getCurrentUserId();
        ArrayList<Interest> interests = (ArrayList<Interest>) interestService.getUserInterests(userId);
        return ResponseEntity.ok().body(interests);
    }

    @PostMapping("/interests/add")
    public void addInterest(@RequestBody Interest interest) throws Exception {
        interestService.insertInterest(interest, sessionService.getCurrentUserId());
    }

    @DeleteMapping("/interests/delete/{id}")
    public void deleteInterest(@PathVariable("id") Integer id) {
        interestService.deleteInterestById(id);
    }

}
