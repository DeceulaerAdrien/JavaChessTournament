package com.example.repositories;

import com.example.models.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    @Query("SELECT t FROM Tournament t WHERE t.statut NOT LIKE 'FINI' ORDER BY t.updateAt DESC LIMIT 10")
    List<Tournament> findTenNotOver();
}
