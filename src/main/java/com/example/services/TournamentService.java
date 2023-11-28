package com.example.services;

import com.example.models.entities.Tournament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentService {

    Tournament create(Tournament tournament);

    void delete(Long id);

    Tournament getbyId(Long id);

    List<Tournament> getTenNotOVer();

    Tournament getDetails(long id);

    Tournament update(Long id, Tournament tournament);

    void inscription(Long memberId, Long tournamentId);

    void desinscription(Long id);

}