package com.kiraDegu.UploadDownloadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class UploadController {

    @Autowired
    private FilesStorageService filesStorageService;

    @PostMapping("")
    public String uploadFile(@RequestParam(value = "fileToUpload") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is Empty";
        }
        try {
            filesStorageService.saveFile(file);
            return "File salvato con successo!";
        } catch (IOException e) {
            return "Errore di input del file. Non riesco a leggerlo";
        } catch (Exception e) {
            return "C'è stato un errore generico";
        }
    }

    @GetMapping("")
    public ResponseEntity<Resource> readFile(@RequestParam(value = "fileName") String fileName) {
        Resource resource = filesStorageService.readFile(fileName);
        return ResponseEntity.ok().header(
                HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\""
        ).body(
                resource
        );
    }
}
