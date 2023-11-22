package com.example.exceptions.member;

public abstract class MemberException extends RuntimeException {
    public MemberException(String message) {
        super(message);
    }
}
