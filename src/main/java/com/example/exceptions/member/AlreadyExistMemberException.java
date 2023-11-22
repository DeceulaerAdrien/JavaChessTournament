package com.example.exceptions.member;

public class AlreadyExistMemberException extends MemberException {
    public AlreadyExistMemberException() {
        super("A Member with this username already exist !");
    }

    public AlreadyExistMemberException(String message) {
        super(message);
    }
}