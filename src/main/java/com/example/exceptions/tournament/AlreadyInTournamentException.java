package com.example.exceptions.tournament;

public class AlreadyInTournamentException extends TournamentException{
    public AlreadyInTournamentException(){
        super("Vous êtes déja inscrit dans ce tournois");
    }
    public AlreadyInTournamentException(String message) {
        super(message);
    }
}
