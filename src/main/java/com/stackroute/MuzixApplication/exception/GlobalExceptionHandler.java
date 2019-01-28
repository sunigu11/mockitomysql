package com.stackroute.MuzixApplication.exception;


import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Not all mandatory fields are filled")
    @ExceptionHandler(TrackAlreadyExistException.class)
    public void HandleTrackAlreadyExistException(TrackAlreadyExistException e){

       // log.error("Track already exists", e);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="track not found")
    @ExceptionHandler(TrackNotFoundException.class)
    public void HandleTrackNotFoundException(TrackNotFoundException e){
        //log.error("track not found exception", e);
    }

}
