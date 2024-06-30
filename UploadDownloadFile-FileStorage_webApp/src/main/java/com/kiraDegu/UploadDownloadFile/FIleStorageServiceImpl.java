package com.kiraDegu.UploadDownloadFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FIleStorageServiceImpl implements FilesStorageService{

    @Value("${directoryStoragePath}")
    private String direcory;

    private static final Logger logger = LoggerFactory.getLogger(FilesStorageService.class);

    @Override
    public Resource readFile(String fileName) {
        try{
            Path path = Paths.get(direcory);
            path = path.resolve(fileName).normalize();
            return new UrlResource(path.toUri());
        } catch (MalformedURLException e){
            logger.error("Errore nell'url. Non è possibile continuare.");
        }
        return null;
    }

    @Override
    public void saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        direcory += fileName;
        try {
            Files.copy(file.getInputStream(), Path.of(direcory), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            logger.error("Errore salvataggio file" + fileName, e);
            throw e;
        }
    }

}
