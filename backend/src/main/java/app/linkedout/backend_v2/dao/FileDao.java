package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.File;

import java.util.List;

public interface FileDao {
    List<File> getFilesByUserIdAndType(int user_id, String content_type);
    int insertFile(File file);
    int updateFile(File file);
}