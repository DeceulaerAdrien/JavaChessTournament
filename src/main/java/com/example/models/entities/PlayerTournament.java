package com.example.models.entities;

import com.example.models.entities.members.Player;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class PlayerTournament extends BaseRelation<PlayerTournament.PlayerTournamentId>{

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerId")
    @Setter
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerId")
    @Setter
    private Tournament tournament;

    @Getter
    public static class PlayerTournamentId implements Serializable {
        @Setter
        private long playerId;
        @Setter
        private long tournamentId;
    }
}
