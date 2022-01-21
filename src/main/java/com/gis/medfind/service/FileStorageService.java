package com.gis.medfind.service;

import java.nio.file.Path;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    public void initialize();

    public void upload(MultipartFile file);

    public Resource getFile(String filename);

    public boolean deleteAll();

    public boolean deleteByName(String fileName);

    public List<Path> loadAllFiles();
}
