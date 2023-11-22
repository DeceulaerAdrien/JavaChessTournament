package com.example.repositories.security;

import com.example.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Member , long> {

    @Query("Select m From Member Where m.Member_Pseudonyme Ilike :Member_Pseudonyme")
    Optional<Member> findByUserPseudo(String pseudo);
}
