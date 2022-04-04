package com.utils;

public class LoginException extends RuntimeException{
    private static final long serialVersionUID = -2576907034927527608L;

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
