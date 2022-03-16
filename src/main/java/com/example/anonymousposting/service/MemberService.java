package com.example.anonymousposting.service;

import com.example.anonymousposting.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository repository;
}
