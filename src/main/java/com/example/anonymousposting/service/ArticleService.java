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

    public Article save(MultipartFile file, HttpServletRequest request) {
        Attachment photo = attachmentService.save(file);
        System.out.println(photo);
        return repository.save(Article.builder()
                .postText(request.getParameter("textarea"))
                .title("main title")
                .attachment(photo)
                .date(new Date())
                .build());
    }
}
