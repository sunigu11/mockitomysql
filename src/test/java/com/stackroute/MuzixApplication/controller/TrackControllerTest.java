package com.stackroute.MuzixApplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistException;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import com.stackroute.MuzixApplication.service.TrackService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackController userController;

    private List<Track> list =null;
    //private TrackRepository trackRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId(111);
        track.setTrackName("gullyboy");
        track.setComment("good goog");
        list = new ArrayList<>();
        list.add(track);
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void saveTrack() throws Exception{
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
    }

//    @Test
//    public void getAllUser() throws Exception {
//        when(userService.getAllUser()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/userservice")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }

    @Test
    public void getAllTrack() throws Exception{
        when(trackService.getAllTrack()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }



//    public void saveUserFailure() throws Exception {
//        when(userService.saveUser(any())).thenThrow(UserAlreadyExistException.class);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/userservice")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }

    @Test
    public void saveTrackFailure() throws Exception{
        when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track").contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(track))).andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}