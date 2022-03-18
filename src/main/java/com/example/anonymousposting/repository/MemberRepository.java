package com.example.anonymousposting.repository;

import com.example.anonymousposting.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByUsernameAndPassword(String username, String password);
}
