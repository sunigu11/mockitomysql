package com.stackroute.MuzixApplication.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
//import org.springframework.data.mongodb.core.mapping.Document;


//@Document(collection = "Tracks")
@Entity
@Data
@NoArgsConstructor
public class Track {

   @Id
    private int trackId;
    private String trackName;
    private String comment;
    public Track(int trackId, String trackName, String comment) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comment = comment;
    }



}
