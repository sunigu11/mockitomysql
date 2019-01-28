package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

}
