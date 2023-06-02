package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.FileDao;
import app.linkedout.backend_v2.dao.InterestDao;
import app.linkedout.backend_v2.models.File;
import app.linkedout.backend_v2.models.Interest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    private final FileDao fileDao;

    public FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public List<File> getFilesByUserIdAndType(int user_id, String content_type) {
        return fileDao.getFilesByUserIdAndType(user_id, content_type);
    }
    public int insertFile(File file) {
        return fileDao.insertFile(file);
    }
    public int updateFile(File file)
    {
        return fileDao.updateFile(file);
    }
}
