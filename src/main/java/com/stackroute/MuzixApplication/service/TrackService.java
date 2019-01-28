package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistException;
import com.stackroute.MuzixApplication.exception.TrackNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistException;
    public List<Track> getAllTrack();
    public Track updateTrack(Track track) throws TrackNotFoundException;
    public Track removeTrack(int trackId) throws TrackNotFoundException;
}
