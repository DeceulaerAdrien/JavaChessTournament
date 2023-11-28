package com.example.exceptions.tournament;

public class BadNumberOfEloException extends TournamentException{
    public BadNumberOfEloException(){
        super("Vous n'avez pas le bon nombre de points Elo");
    }
    public BadNumberOfEloException(String message) {
        super(message);
    }
}
