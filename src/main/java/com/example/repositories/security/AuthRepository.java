package com.example.repositories.security;

import com.example.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Member,Long> {
    @Query("SELECT m FROM Member m WHERE m.username ILIKE :member_username")
    Optional<Member> findByUserPseudo(String pseudo);
}
