package com.projectoSpring.springboot.backend.apirest.models.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

    public Resource carry(String namePhoto) throws MalformedURLException;

    public String copy(MultipartFile archive) throws IOException;
    public boolean delete(String namePhoto);
    public Path getPath(String namePhoto);
}
