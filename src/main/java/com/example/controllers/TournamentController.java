package com.example.controllers;

import com.example.models.dtos.member.MemberShortDTO;
import com.example.models.dtos.tournament.TournamentDTO;
import com.example.models.entities.Member;
import com.example.models.entities.Tournament;
import com.example.models.forms.MemberForm;
import com.example.models.forms.TournamentForm;
import com.example.services.MemberService;
import com.example.services.TournamentService;
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

    private final MemberService memberService;

    public TournamentController(TournamentService tournamentService, MemberService memberService) {
        this.tournamentService = tournamentService;
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Tournament> create(@RequestBody @Valid TournamentForm tournamentForm){
        Tournament tournament = tournamentService.create(tournamentForm.toEntity());
        return ResponseEntity.ok(tournament
                //TournamentDTO.fromEntity(tournament)
        );
    }
}
