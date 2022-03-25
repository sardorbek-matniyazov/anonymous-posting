package com.example.anonymousposting.service;

import com.example.anonymousposting.entity.Attachment;
import com.example.anonymousposting.payload.Constants;
import com.example.anonymousposting.repository.AttachmentRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    @SneakyThrows
    public Attachment save(MultipartFile file) {
        if (file != null && !file.isEmpty()){
            String string = UUID.randomUUID().toString();
            String[] split = file.getOriginalFilename().split("\\.");
            string += "." + split[split.length - 1];
            Attachment save = attachmentRepository.save(
                    Attachment.builder()
                            .contentType(file.getContentType())
                            .fileOriginalName(file.getOriginalFilename())
                            .size(file.getSize())
                            .fileName(string)
                            .build()
            );
            Path path = Paths.get(Constants.imagesPath + string);
            Files.copy(file.getInputStream(), path);
            return save;
        }
        return null;
    }

    public File getFile(String name) {
        return new File(Constants.imagesPath + name);
    }
}
