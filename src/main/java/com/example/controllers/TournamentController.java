package com.example.controllers;


import com.example.models.dtos.tournament.TournamentDTO;
import com.example.models.entities.Tournament;
import com.example.models.forms.TournamentForm;
import com.example.services.TournamentService;
import com.example.services.security.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournament")
public class TournamentController {
    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public ResponseEntity<TournamentDTO> create(@RequestBody @Valid TournamentForm tournamentForm) {
        Tournament tournament = tournamentService.create(tournamentForm.toEntity());
        return ResponseEntity.ok(TournamentDTO.fromEntity(tournament));
    }
}
