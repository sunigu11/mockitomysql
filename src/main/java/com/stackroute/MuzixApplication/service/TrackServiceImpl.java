package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistException;
import com.stackroute.MuzixApplication.exception.TrackNotFoundException;
//import com.stackroute.MuzixApplication.repository.TrackRepository;
import com.stackroute.MuzixApplication.repository.TrackRepository;
//import com.stackroute.MuzixApplication.repository.TrackRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

   // TrackRepository trackRepository;
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistException("track already exist exception");
        }
        return  trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrack() {

        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {

        if(trackRepository.existsById(track.getTrackId())){
            /*Track updatedTrack = trackRepository.getOne(track.getTrackId());
            updatedTrack.setTrackName(track.getTrackName());
            updatedTrack.setComment(track.getComment());
            trackRepository.save(updatedTrack);*/
            return  trackRepository.save(track);

        }
        else {
            throw  new TrackNotFoundException("no such track exist with the given track id to update");
        }


    }

    @Override
    public Track removeTrack(int trackId) throws TrackNotFoundException {
        if(trackRepository.existsById(trackId)){
            trackRepository.deleteById(trackId);
          return  trackRepository.findById(trackId).get();
            //return trackRepository.getOne(trackId);
        }
       else {
            throw new TrackNotFoundException("track does not exist");
        }


    }
}
