package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.models.File;
import app.linkedout.backend_v2.services.FileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/files")
public class FileController  {

    private final FileService fileService ;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("{user_id}/{content_type}")
    public List<File> getFileByUserIdAndType(@PathVariable("user_id") Integer user_id,
                                             @PathVariable("content_type") String contentType) throws Exception {
        return fileService.getFilesByUserIdAndType(user_id, contentType);
    }

    @PostMapping
    public void insertFile(@RequestBody File file) {
        fileService.insertFile(file);
    }

    @PutMapping()
    public void updateFile(@RequestBody File file)
    {
        fileService.updateFile(file);
    }
}