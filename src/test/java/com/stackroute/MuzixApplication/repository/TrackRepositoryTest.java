package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;
    @Before
    public void setUp() throws Exception {
        track = new Track();
        track.setTrackId(10);
        track.setTrackName("terebin");
        track.setComment("good");
    }

    @After
    public void tearDown() throws Exception {
        trackRepository.deleteAll();
    }
    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();
        Assert.assertEquals(10,fetchTrack.getTrackId());

    }

    @Test
    public void testSaveTrackFailure(){
        //Track testTrack = new Track(11,"xyz","bad");
        //
        // Track testTrack = new Track((11"xyz","bad");
        Track testTrack = new Track(13,"xuz","bad");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getTrackId()).get();


        Assert.assertNotSame(testTrack,fetchTrack);

    }

    @Test
    public void testGetAllTrack(){
        Track t1 = new Track(15,"abc","good");
        Track t2 = new Track(16,"pqr","very");

        trackRepository.save(t1);
        trackRepository.save(t2);
        List<Track> list = trackRepository.findAll();
       // Assert.assertEquals("Johny",list.get(0).getFirstName());
        Assert.assertEquals("abc",list.get(3).getTrackName());



    }

}