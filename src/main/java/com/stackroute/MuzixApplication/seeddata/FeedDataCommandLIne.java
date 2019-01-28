package com.stackroute.MuzixApplication.seeddata;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.service.TrackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@Data
@PropertySource("application.properties")
public class FeedDataCommandLIne implements CommandLineRunner {

    private Track feedTrackData = new Track();
    @Value("${song.total}")
    private int totalSongs;
    @Value("${song.1.trackId}")
    private int id1;
    @Value("${song.1.trackName}")
    private String name1;
    @Value("${song.1.comment}")
    private String comment1;
    @Value("${song.2.trackId}")
    private int id2;
    @Value("${song.2.trackName}")
    private String name2;
    @Value("${song.2.comment}")
    private String comment2;
    @Value("${song.3.trackId}")
    private int id3;
    @Value("${song.3.trackName}")
    private String name3;
    @Value("${song.3.comment}")
    private String comment3;




    @Autowired
    Environment env;
    @Autowired
    private TrackService trackServices;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(env.getProperty("app.name"));
        System.out.println(env.getProperty("JAVA_HOME"));
//        feedTrackData.setTrackId(id1);
//        feedTrackData.setTrackName(name1);
//        feedTrackData.setComment(comment1);
//        trackServices.saveTrack(feedTrackData);
        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.1.trackId")));
        feedTrackData.setTrackName(env.getProperty("song.1.trackName"));
        feedTrackData.setComment(env.getProperty("song.1.comment"));
        trackServices.saveTrack(feedTrackData);

        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.2.trackId")));
        feedTrackData.setTrackName(env.getProperty("song.2.trackName"));
        feedTrackData.setComment(env.getProperty("song.2.comment"));
        trackServices.saveTrack(feedTrackData);

        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.3.trackId")));
        feedTrackData.setTrackName(env.getProperty("song.3.trackName"));
        feedTrackData.setComment(env.getProperty("song.3.comment"));
        trackServices.saveTrack(feedTrackData);


    }
}
