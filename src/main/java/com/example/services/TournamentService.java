package com.example.services;

import com.example.models.entities.Member;
import com.example.models.entities.Tournament;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface TournamentService {

    Tournament create (Tournament tournament);

    void delete (Long id);

    Tournament getbyId (Long id);

    List<Tournament> getAll ();

    Tournament update(Long id, Tournament tournament);

    void inscription(Long memberId, Long tournamentId);

    void desinscription(Long id);

}