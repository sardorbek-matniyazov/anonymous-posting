package com.example.anonymousposting.repository;

import com.example.anonymousposting.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
