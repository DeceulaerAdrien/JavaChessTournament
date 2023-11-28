package com.example.controllers;


import com.example.models.dtos.tournament.TournamentDTO;
import com.example.models.entities.Tournament;
import com.example.models.forms.TournamentForm;
import com.example.services.TournamentService;
import com.example.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {
    private final TournamentService tournamentService;
    private final JwtUtils jwtUtils;

    public TournamentController(TournamentService tournamentService, JwtUtils jwtUtils) {
        this.tournamentService = tournamentService;
        this.jwtUtils = jwtUtils;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(path = "/create")
    public ResponseEntity<TournamentDTO> create(@RequestBody @Valid TournamentForm tournamentForm) {
        Tournament tournament = tournamentService.create(tournamentForm.toEntity());
        return ResponseEntity.ok(TournamentDTO.fromEntity(tournament));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TournamentDTO> getById(@PathVariable("id") Long id) {
        TournamentDTO tournamentDTO = TournamentDTO.fromEntity(this.tournamentService.getbyId(id));
        return ResponseEntity.ok(tournamentDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TournamentDTO>> getAll() {
        List<Tournament> tournaments = tournamentService.getTenNotOVer();
        List<TournamentDTO> tournamentDTO = tournaments.stream().map(TournamentDTO::fromEntity).toList();
        return ResponseEntity.ok(tournamentDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<TournamentDTO> update(
            @PathVariable("id") Long id,
            @RequestBody TournamentForm tournamentForm
    ) {
        TournamentDTO tournamentDTO = TournamentDTO.fromEntity(this.tournamentService.update(id, tournamentForm.toEntity()));
        return ResponseEntity.ok(tournamentDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Long id
    ) {

        this.tournamentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/inscription/{tournamentId}")
    public ResponseEntity<Object> inscription(
            Authentication authentication,
            @PathVariable Long tournamentId
    ){
        String token = authentication.getCredentials().toString();
        Long memberId = jwtUtils.getId(token);

        tournamentService.inscription(memberId,tournamentId);

        return ResponseEntity.status(200).body("Inscription validée");
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/desinscription/{tournamentId}")
    public ResponseEntity<Object> desinscription(
            Authentication authentication,
            @PathVariable Long tournamentId
    ){
        String token = authentication.getCredentials().toString();
        Long memberId = jwtUtils.getId(token);

        tournamentService.desinscription(memberId,tournamentId);

        return ResponseEntity.status(200).body("Vous avez été désinscrit du tournois");
    }
}
