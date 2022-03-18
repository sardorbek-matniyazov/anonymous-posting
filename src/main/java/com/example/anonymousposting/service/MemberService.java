package com.example.anonymousposting.service;

import com.example.anonymousposting.entity.Member;
import com.example.anonymousposting.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public Member getByNameAndPassword(String username, String password) {
        Optional<Member> byUsernameAndPassword = repository.findByUsernameAndPassword(username, password);
        return byUsernameAndPassword.orElseGet(Member::new);
    }
}
