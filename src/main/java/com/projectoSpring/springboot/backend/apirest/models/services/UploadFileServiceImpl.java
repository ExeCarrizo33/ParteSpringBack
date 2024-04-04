package com.projectoSpring.springboot.backend.apirest.models.services;

import com.projectoSpring.springboot.backend.apirest.controllers.ClienteRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    private final static String DIRECTORY_UPLOAD = "uploads";

    @Override
    public Resource carry(String namePhoto) throws MalformedURLException {
        Path filePath = getPath(namePhoto);
        log.info(filePath.toString());

        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() && !resource.isReadable()) {
            filePath = Paths.get("src/main/resources/static/img").resolve("285645_user_icon.png").toAbsolutePath();
            resource = new UrlResource(filePath.toUri());

            log.error("Error no se pudo cargar la imagen: " + namePhoto);
        }
        return resource;
    }

    @Override
    public String copy(MultipartFile archive) throws IOException {
        String nameArchive = UUID.randomUUID().toString() + "_" + archive.getOriginalFilename().replace(" ", "");
        Path filePath = getPath(nameArchive);
        log.info(filePath.toString());

        Files.copy(archive.getInputStream(), filePath);

        return nameArchive;
    }

    @Override
    public boolean delete(String namePhoto) {
        if (namePhoto != null && !namePhoto.isEmpty()) {
            Path routePhotoPrevious = Paths.get("uploads").resolve(namePhoto).toAbsolutePath();
            File filePhotoPrevious = routePhotoPrevious.toFile();
            if (filePhotoPrevious.exists() & filePhotoPrevious.canRead()) {
                filePhotoPrevious.delete();
                return true;
            }
        }
        return false;
    }

    @Override
    public Path getPath(String namePhoto) {
        return Paths.get("uploads").resolve(namePhoto).toAbsolutePath();
    }
}
