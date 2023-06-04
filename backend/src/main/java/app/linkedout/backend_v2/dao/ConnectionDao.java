package app.linkedout.backend_v2.dao;

import java.util.HashMap;
import java.util.List;

public interface ConnectionDao {
    public String getConnectionStatus(int userId, int targetUserId);
    public Object insertRequest(int userId, int targetUserId);
    public Object acceptRequest(int userId, int targetUserId);
    public Object deleteConnection(int userId, int targetUserId);
    public List<HashMap<String, Object>> getNetwork(int userId, int offset);
    public List<HashMap<String, Object>> getSuggestions(int userId, int offset);
}