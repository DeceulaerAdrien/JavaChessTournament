package com.example.repositories.security;

import com.example.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {


    @Query("SELECT count(m) > 0 FROM Member m WHERE m.username ILIKE :username")
    boolean existsByUsername(String username);
    @Query("SELECT m FROM Member m where m.username ILIKE :username")
    Optional<Member> findByUsername(String username);
}