package com.example.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class MemberTournament extends BaseRelation<MemberTournament.MembertournamentId> {

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("memberId")
    @Setter
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("tournamentId")
    @Setter
    private Tournament tournament;

    @Getter
    public static class MembertournamentId implements Serializable {
        @Setter
        private long memberId;
        @Setter
        private long tournamentId;
    }
}