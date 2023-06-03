package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.services.PostService;
import app.linkedout.backend_v2.services.SessionService;
import app.linkedout.backend_v2.dto.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    private final PostService postService;
    private final SessionService sessionService;

    public PostController(PostService postService, SessionService sessionService) {
        this.postService = postService;
        this.sessionService = sessionService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("feed")
    public Object getFeed(@RequestParam(name = "offset") int offset) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }


        int userId = (int) controlResult;
        return postService.getFeed(userId, offset);
    }
}
