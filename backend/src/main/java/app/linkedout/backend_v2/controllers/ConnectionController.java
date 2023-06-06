package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.services.ConnectionService;
import app.linkedout.backend_v2.services.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/connections")
public class ConnectionController {
    private final ConnectionService connectionService;
    private final SessionService sessionService;

    public ConnectionController(ConnectionService connectionService, SessionService sessionService) {
        this.connectionService = connectionService;
        this.sessionService = sessionService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{userId}/sendRequest")
    public Object sendConnectionRequest(@PathVariable("userId") Integer targetUserId) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.sendRequest(userId, targetUserId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{userId}/accept")
    public Object acceptConnectionRequest(@PathVariable("userId") Integer targetUserId) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.acceptRequest(userId, targetUserId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{userId}/decline")
    public Object declineConnectionRequest(@PathVariable("userId") Integer targetUserId) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.declineRequest(userId, targetUserId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{userId}/cancel")
    public Object cancelConnectionRequest(@PathVariable("userId") Integer targetUserId) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.cancelRequest(userId, targetUserId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("{userId}/unlink")
    public Object removeConnection(@PathVariable("userId") Integer targetUserId) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.removeConnection(userId, targetUserId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("network")
    public Object getNetwork(@RequestParam(name = "offset") int offset) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.getNetwork(userId, offset);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("requests")
    public Object getRequests(@RequestParam(name = "offset") int offset) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.getRequests(userId, offset);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("suggestions")
    public Object getSuggestions(@RequestParam(name = "offset") int offset) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.getSuggestions(userId, offset);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("suggestions-alternative")
    public Object getAlternativeSuggestions(@RequestParam(name = "offset") int offset) {
        Object controlResult = sessionService.gutCurrentUserIdIfExists();
        if (controlResult instanceof ResponseEntity) {
            return controlResult;
        }

        int userId = (int) controlResult;
        return connectionService.getAlternativeSuggestions(userId, offset);
    }
}
