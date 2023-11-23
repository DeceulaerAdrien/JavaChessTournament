package com.example.models.entities;

import com.example.models.entities.enums.TournamentCategoriesEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Tournament extends BaseEntity<Long> {

    @Setter
    @Column(name = "Tournament_name")
    private String name;

    @Setter
    @Column(name = "Tournament_location")
    private String location;

    @Setter
    @Column(name = "Tournament_categorie")
    @Enumerated(EnumType.STRING)
    private TournamentCategoriesEnum categorie;

    @Setter
    @Column(name = "Tournament_statut")
    private String statut;

    @Setter
    @Column(name = "Tournament_min_player")
    @Range(min = 2, max = 32)
    private int minPlayer;

    @Setter
    @Range(min = 2, max = 32)
    @Column(name = "Tournament_max_player")
    private int maxPlayer;

    @Setter
    @Range(min = 0, max = 3000)
    @Column(name = "Tournament_min_elo")
    private int minElo;

    @Setter
    @Column(name = "Tournament_max_elo")
    private int maxElo;

    @Setter
    @Column(name = "Tournament_round")
    private int round;

    @Setter
    @Column(name = "Tournament_women_only")
    private boolean womenOnly;

    @Setter
    @Column(name = "Tournament_end_inscription_date")
    private LocalDate endInscritpionDate;

}
