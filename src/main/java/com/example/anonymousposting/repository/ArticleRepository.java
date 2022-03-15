package com.example.anonymousposting.repository;

import com.example.anonymousposting.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
