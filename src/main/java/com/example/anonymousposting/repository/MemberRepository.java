package com.example.anonymousposting.repository;

import com.example.anonymousposting.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
