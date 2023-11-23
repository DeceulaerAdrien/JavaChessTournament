package com.example.services.security.impl;

import com.example.models.entities.Tournament;
import com.example.repositories.TournamentRepository;
import com.example.services.TournamentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    public final TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament create(Tournament tournament) {
        return null;
    }

    @Override
    public Void delete(Tournament tournament) {
        return null;
    }

    @Override
    public Tournament getbyId(Long id) {
        return null;
    }

    @Override
    public List<Tournament> getAll() {
        return null;
    }
}
