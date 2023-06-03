package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.ConnectionDao;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ConnectionService {

    private final ConnectionDao connectionDao;

    public ConnectionService(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }

}
