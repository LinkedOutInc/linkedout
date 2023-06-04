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
}
