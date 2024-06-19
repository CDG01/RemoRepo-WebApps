package com.kiraDegu.UploadDownloadFile;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FilesStorageService {
    Resource readFile(String path);
    void saveFile(MultipartFile file) throws IOException;
    void deleteFile(String path);
}
