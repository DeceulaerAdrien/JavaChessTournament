package com.example.repositories;

import com.example.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT count(m) > 0 FROM Member m WHERE m.username ILIKE :username")
    boolean existsByUsername(String username);

}
