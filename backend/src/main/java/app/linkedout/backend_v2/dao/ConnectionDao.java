package app.linkedout.backend_v2.dao;

public interface ConnectionDao {
    public String getConnectionStatus(int userId, int targetUserId);
    public Object insertRequest(int userId, int targetUserId);
    public Object acceptRequest(int userId, int targetUserId);
    public Object deleteConnection(int userId, int targetUserId);
}