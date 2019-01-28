package com.stackroute.MuzixApplication.service;

import com.google.common.base.Verify;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistException;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    private Track track;

    @Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private TrackServiceImpl trackService;

    List<Track> list = null;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId(1);
        track.setTrackName("terebin");
        track.setComment("good");
        list = new ArrayList<>();
        list.add(track);
    }



    @Test
    public  void saveTrackTestSuccess() throws TrackAlreadyExistException{
        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        verify(trackRepository,times(1)).save(track);
    }

//    @Test(expected = UserAlreadyExistException.class)
//    public void saveUserTestFailure() throws UserAlreadyExistException {
//        when(userRepository.save((User)any())).thenReturn(null);
//        User savedUser = userService.saveUser(user);
//        System.out.println("savedUser" + savedUser);
//        Assert.assertEquals(user,savedUser);
//
//       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
//       userService.saveUser(user);*/
//
//
//    }

//    @Test//(expected = TrackAlreadyExistException.class)
//    public void saveTrackTestFailure() {
//        when(trackRepository.save((Track)any())).thenThrow(TrackAlreadyExistException.class);
//        //doThrow(new TrackAlreadyExistException("failed")).when(trackRepository).findById(eq(1));
////
//        //Track savedTrack =
////        try {
////            trackService.saveTrack(track);
////        } catch (TrackAlreadyExistException e) {
////            e.printStackTrace();
////        }
//        trackRepository.save(track);
//
//        Assert.assertNotEquals("Not all mandatory fields are filled",track);
//    }

//    @Test
//    public void getAllUser(){
//
//        userRepository.save(user);
//        //stubbing the mock to return specific data
//        when(userRepository.findAll()).thenReturn(list);
//        List<User> userlist = userService.getAllUser();
//        Assert.assertEquals(list,userlist);
//    }

    @Test
    public void getAllTrack(){
        trackRepository.save(track);
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> trackList = trackService.getAllTrack();
        Assert.assertEquals(list,trackList);
    }

}