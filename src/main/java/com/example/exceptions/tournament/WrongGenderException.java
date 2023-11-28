package com.example.exceptions.tournament;

public class WrongGenderException extends TournamentException{
    public WrongGenderException(){
        super("Ce tournois est réservé aux femmes");
    }
    public WrongGenderException(String message) {
        super(message);
    }
}
