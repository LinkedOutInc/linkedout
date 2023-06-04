package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.File;
import app.linkedout.backend_v2.services.FileService;
import app.linkedout.backend_v2.services.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/files")
public class FileController  {

    private final FileService fileService ;
    private final SessionService sessionService;
    public FileController(FileService fileService, SessionService sessionService) {
        this.fileService = fileService;
        this.sessionService = sessionService;
    }

    @GetMapping("/{user_ID}/{content_type}")
    public List<File> getFileByUserIdAndType(@PathVariable("user_ID") Integer user_ID, @PathVariable("content_type") String contentType) throws Exception {
        return fileService.getFilesByUserIdAndType(user_ID, contentType);
    }

    @PostMapping
    public void insertFile(@RequestBody File file) throws Exception {
        int user_id = sessionService.getCurrentUserId();
        fileService.insertFile(file, user_id);
    }

    @PutMapping()
    public void updateFile(@RequestBody File file)
    {
        fileService.updateFile(file);
    }
}