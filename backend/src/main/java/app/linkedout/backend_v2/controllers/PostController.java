package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.Comment;
import app.linkedout.backend_v2.models.FeedPost;
import app.linkedout.backend_v2.models.Reaction;
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

    @CrossOrigin(origins = "*")
    @PostMapping("new")
    public Object newPost(@RequestBody FeedPost feedPost) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return postService.newPost(userId, feedPost);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("{id}")
    public Object deletePost(@PathVariable("id") Integer id) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return postService.deletePost(userId, id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("{id}/comments")
    public Object getComments(@PathVariable("id") Integer id, @RequestParam(name = "offset") int offset) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return postService.getComments(id, offset);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{id}/comments/new")
    public Object newComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return postService.newComment(id, comment, userId);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("{postId}/comments/{commentId}")
    public Object newComment(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return postService.deleteComment(postId, commentId, userId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{postId}/reactions/currentUser")
    public Object updateReaction(@PathVariable("postId") Integer postId, @RequestBody Reaction reaction) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return postService.updateReaction(postId, reaction.type(), userId);
    }
}
