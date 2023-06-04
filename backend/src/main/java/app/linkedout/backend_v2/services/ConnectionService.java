package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.ConnectionDao;
import app.linkedout.backend_v2.dto.Error;
import app.linkedout.backend_v2.dto.Success;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ConnectionService {

    private final ConnectionDao connectionDao;

    public ConnectionService(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }

    public Object sendRequest(int userId, int targetUserId) {
        // Get connection status
        String status = connectionDao.getConnectionStatus(userId, targetUserId);
        switch (status) {
            case "LINKED":
                return Success.create("Already linked.");
            case "UNLINKED":
                return connectionDao.insertRequest(userId, targetUserId);
            case "REQUESTED":
                return Error.create(400, "Request has already been sent.");
            case "WAITING":
                return Error.create(400, "This user has already sent you a request; accept it instead.");
            default: // UNKNOWN
                return Error.create(500, "Connection status could not be retrieved.");
        }
    }
}
