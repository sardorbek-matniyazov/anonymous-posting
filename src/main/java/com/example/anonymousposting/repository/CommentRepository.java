package com.example.anonymousposting.repository;

import com.example.anonymousposting.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
