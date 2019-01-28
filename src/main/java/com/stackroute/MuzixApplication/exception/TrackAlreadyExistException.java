package com.stackroute.MuzixApplication.exception;

public class TrackAlreadyExistException extends Exception {
    String message;

    public TrackAlreadyExistException() {
        this.message = message;
    }

    public TrackAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }

}
