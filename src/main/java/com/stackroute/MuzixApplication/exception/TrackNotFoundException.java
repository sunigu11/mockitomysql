package com.stackroute.MuzixApplication.exception;

public class TrackNotFoundException extends Exception {
    String message;
    public TrackNotFoundException() {
        this.message = message;
    }

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }



}
