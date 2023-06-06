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
        if (userId == targetUserId) {
            return Error.create(400,"Cannot send connection request to self.");
        }

        String status = connectionDao.getConnectionStatus(userId, targetUserId);
        switch (status) {
            case "LINKED":
                return Error.create(400,"Already linked.");
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

    public Object acceptRequest(int userId, int targetUserId) {
        String status = connectionDao.getConnectionStatus(userId, targetUserId);
        switch (status) {
            case "LINKED":
                return Error.create(400,"Already linked.");
            case "UNLINKED":
                return Error.create(400, "No request to accept; send connection request first.");
            case "REQUESTED":
                return Error.create(400, "Request has already been sent.");
            case "WAITING":
                return connectionDao.acceptRequest(targetUserId, userId);
            default: // UNKNOWN
                return Error.create(500, "Connection status could not be retrieved.");
        }
    }

    public Object declineRequest(int userId, int targetUserId) {
        String status = connectionDao.getConnectionStatus(userId, targetUserId);
        switch (status) {
            case "LINKED":
                return Error.create(400,"Already linked; unlink connection instead.");
            case "UNLINKED":
                return Error.create(400, "No request to decline.");
            case "REQUESTED":
                return Error.create(400, "Request has already been sent; cancel request instead.");
            case "WAITING":
                return connectionDao.deleteConnection(targetUserId, userId);
            default: // UNKNOWN
                return Error.create(500, "Connection status could not be retrieved.");
        }
    }

    public Object cancelRequest(int userId, int targetUserId) {
        String status = connectionDao.getConnectionStatus(userId, targetUserId);
        switch (status) {
            case "LINKED":
                return Error.create(400,"Already linked; unlink connection instead.");
            case "UNLINKED":
                return Error.create(400, "No request to cancel.");
            case "REQUESTED":
                return connectionDao.deleteConnection(userId, targetUserId);
            case "WAITING":
                return Error.create(400, "Request is waiting for you to accept or decline.");
            default: // UNKNOWN
                return Error.create(500, "Connection status could not be retrieved.");
        }
    }

    public Object removeConnection(int userId, int targetUserId) {
        String status = connectionDao.getConnectionStatus(userId, targetUserId);
        switch (status) {
            case "LINKED":
                return connectionDao.deleteConnection(userId, targetUserId);
            case "UNLINKED":
                return Error.create(400, "No connection to remove.");
            case "REQUESTED":
                return Error.create(400, "Request is already sent; cancel it instead.");
            case "WAITING":
                return Error.create(400, "Request is waiting for you to accept or decline; decline instead.");
            default: // UNKNOWN
                return Error.create(500, "Connection status could not be retrieved.");
        }
    }

    public List<HashMap<String, Object>> getNetwork(int userId, int offset) {
        return connectionDao.getNetwork(userId, offset);
    }

    public List<HashMap<String, Object>> getRequests(int userId, int offset) {
        return connectionDao.getRequests(userId, offset);
    }

    public List<HashMap<String, Object>> getSuggestions(int userId, int offset) {
        return connectionDao.getSuggestions(userId, offset);
    }

    public List<HashMap<String, Object>> getAlternativeSuggestions(int userId, int offset) {
        return connectionDao.getAlternativeSuggestions(userId, offset);
    }
}
