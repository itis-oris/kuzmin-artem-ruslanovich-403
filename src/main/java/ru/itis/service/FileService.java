package ru.itis.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.handler.exception.FileStorageException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    private final String storagePath = System.getProperty("user.dir") + "/uploads/";


    public String saveFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new FileStorageException("Файл не выбран или пуст");
        }

        if (!file.getContentType().startsWith("image/")) {
            throw new FileStorageException("Можно загружать только изображения!");
        }

        File dir = new File(storagePath);
        if (!dir.exists()) dir.mkdirs();

        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String randomName = UUID.randomUUID().toString() + extension;

        try {
            file.transferTo(new File(storagePath + randomName));
            return randomName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException("Ошибка при сохранении файла");
        }
    }
}