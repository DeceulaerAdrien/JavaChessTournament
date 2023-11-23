package com.example.services;

import com.example.models.entities.Tournament;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentService {

    Tournament create (Tournament tournament);

    Void delete (Tournament tournament);

    Tournament getbyId (Long id);

    List<Tournament> getAll ();

}
