package com.example.models.dtos.tournament;
import com.example.models.entities.Tournament;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString @EqualsAndHashCode
public class TournamentDTO {

    private Long id;

    private String name;

    private String location;

    private String statut;

    private LocalDate endInscriptionDate;
    private int minElo;
    private int maxElo;

    private boolean womenOnly;


//    public static TournamentDTO fromEntity(Tournament tournament) {
//        return new TournamentDTO(
//                tournament.getId()
//
//    }
}
