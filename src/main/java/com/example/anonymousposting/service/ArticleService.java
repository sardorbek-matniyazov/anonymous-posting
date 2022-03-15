package com.example.anonymousposting.service;

import com.example.anonymousposting.entity.Article;
import com.example.anonymousposting.entity.Attachment;
import com.example.anonymousposting.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;
    private final AttachmentService attachmentService;

    public Integer save(MultipartFile file, HttpServletRequest request) {
        Attachment photo = attachmentService.save(file);
        return repository.save(Article.builder()
                .text(request.getAttribute("text").toString())
                .attachment(photo)
                .date(new Date())
                .build()).getId();
    }
}
