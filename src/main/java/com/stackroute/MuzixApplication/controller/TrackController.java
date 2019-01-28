package com.stackroute.MuzixApplication.controller;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistException;
import com.stackroute.MuzixApplication.exception.TrackNotFoundException;
import com.stackroute.MuzixApplication.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value="trackList", description="songs and their description")
public class TrackController {
    TrackService trackService ;

   @Autowired
    public TrackController(TrackService trackService) {

        this.trackService = trackService;
    }

    @ApiOperation(value = "adds new track ")
    @PostMapping(value = "/track")
    public ResponseEntity<?> saveUser(@RequestBody Track track) throws TrackAlreadyExistException {
        ResponseEntity responseEntity;

            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping(value = "/track")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<List<Track>>(trackService.getAllTrack(),HttpStatus.OK);
    }

    @ApiOperation(value = "updates the existing track with the new track")
    @ApiResponses(
           value = { @ApiResponse(code = 401,message = "done"),
                   @ApiResponse(code = 201,message = "returning the whole track")}
    )
    @PutMapping(value="/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;

            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<Track>(track,HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping(value = "/track/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId) throws TrackNotFoundException{
        ResponseEntity<?>  responseEntity;

            trackService.removeTrack(trackId);
            responseEntity = new ResponseEntity<String>(trackId+"is deleted",HttpStatus.OK);

        return responseEntity;
    }

}
