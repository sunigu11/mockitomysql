//package com.stackroute.MuzixApplication.seeddata;
//
//import com.stackroute.MuzixApplication.domain.Track;
//import com.stackroute.MuzixApplication.exception.TrackAlreadyExistException;
//import com.stackroute.MuzixApplication.repository.TrackRepository;
//import com.stackroute.MuzixApplication.service.TrackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{//CommandLineRunner {
//
//    //TrackRepository trackRepository;
//    TrackRepository trackRepository;
//
//    @Autowired
//    public DataLoader(TrackRepository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
//
//
//                trackRepository.save(new Track(1,"abc","worst"));
//                trackRepository.save(new Track(4,"qwe","very worst"));
//    }
//
////    @Override
////    public void run(String... args) throws Exception {
////        trackRepository.save(new Track(1,"abc","good"));
////        Track track1 = new Track(2,"xyz","bad");
////        trackRepository.save(track1);
////    }
//}
