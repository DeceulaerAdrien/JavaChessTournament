package com.example.repositories.security;

import com.example.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Member,Long> {
//    @Query("SELECT m FROM Member WHERE m.Member_Pseudonyme ILIKE :Member_Pseudonyme")
//    Optional<Member> findByUserPseudo(String pseudo);
}
