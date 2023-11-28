package com.example.models.entities;

import com.example.models.entities.enums.TournamentCategorieEnum;
import com.example.models.entities.enums.TournamentStatutEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"name", "location"}, callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class Tournament extends BaseEntity<Long> {

    @Setter
    @Column(name = "Tournament_name", nullable = false)
    private String name;

    @Setter
    @Column(name = "Tournament_location")
    private String location;

    @Setter
    @Column(name = "Tournament_categorie")
    @Enumerated(EnumType.STRING)
    private Set<TournamentCategorieEnum> categorie;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "Tournament_statut", columnDefinition = "varchar default 'EN_ATTENTE_DE_JOUEUR'")
    private TournamentStatutEnum statut;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MEMBER_TOURNAMENT",
            joinColumns = @JoinColumn(name = "TOURNAMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "MEMBER_ID")
    )
    private Set<Member> memberSet = new HashSet<>();

    public Set<Member> getMemberSet() {
        return Set.copyOf(this.memberSet);
    }

    public void addMember(Member member) {
        this.memberSet.add(member);
        member.addTournament(this);
    }

    public void removeMember(Member member) {
        this.memberSet.remove(member);
    }
}
