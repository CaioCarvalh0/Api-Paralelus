package com.api.paralelus.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    @Value("${app.upload-dir}")
    private String uploadDir;

    public String salvarArquivo(MultipartFile file, String subpasta, String nomeArquivo) throws IOException {
        Path pastaDestino = Paths.get(uploadDir, subpasta).toAbsolutePath().normalize();
        Files.createDirectories(pastaDestino);

        Path destino = pastaDestino.resolve(nomeArquivo);
        Files.copy(file.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/" + subpasta + "/" + nomeArquivo;
    }
}
