package com.example.anonymousposting.service;

import com.example.anonymousposting.entity.Article;
import com.example.anonymousposting.entity.Comment;
import com.example.anonymousposting.repository.ArticleRepository;
import com.example.anonymousposting.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository repository;
    private final ArticleRepository articleRepository;

    public void saveComment(Integer id, String comment) {
        Article article = articleRepository.getById(id);
        repository.save(
                Comment.builder()
                        .article(article)
                        .comment(comment)
                        .date(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                        .reaction(0)
                        .build()
        );
    }
}
