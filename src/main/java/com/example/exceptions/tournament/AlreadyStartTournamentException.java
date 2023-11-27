package com.example.exceptions.tournament;

public class AlreadyStartTournamentException extends TournamentException{
    public AlreadyStartTournamentException() {
        super("Le tournoi ne peut pas être supprimé car déja en cours !");
    }    public AlreadyStartTournamentException(String message) {
        super(message);
    }
}
