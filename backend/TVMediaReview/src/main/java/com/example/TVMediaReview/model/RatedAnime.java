package com.example.TVMediaReview.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "RatedAnime")
@EntityListeners(AuditingEntityListener.class)
public class RatedAnime implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ratedAnimeID;
    
    String ratedAnimeCustomID;

    @NotBlank
    String ratedAnimeName;
    
    String ratedAnimeImage;

    int ratedAnimeRating;

    long ratedAnimeDescription;

    public RatedAnime() {

    }

    public RatedAnime(String ratedAnimeCustomID, @NotBlank String ratedAnimeName, String ratedAnimeImage, int ratedAnimeRating, long ratedAnimeDescription) {
        super();
        this.ratedAnimeCustomID = ratedAnimeCustomID;
        this.ratedAnimeName = ratedAnimeName;
        this.ratedAnimeImage = ratedAnimeImage;
        this.ratedAnimeRating = ratedAnimeRating;
        this.ratedAnimeDescription = ratedAnimeDescription;
    }

    public Long getRatedAnimeID() {
        return ratedAnimeID;
    }

    public void setRatedAnimeID(Long ratedAnimeID) {
        this.ratedAnimeID = ratedAnimeID;
    }

    public String getRatedAnimeCustomID() {
        return ratedAnimeCustomID;
    }

    public void setRatedAnimeCustomID(String ratedAnimeCustomID) {
        this.ratedAnimeCustomID = ratedAnimeCustomID;
    }

    public String getRatedAnimeName() {
        return ratedAnimeName;
    }

    public void setRatedAnimeName(String ratedAnimeName) {
        this.ratedAnimeName = ratedAnimeName;
    }

    public String getRatedAnimeImage() {
        return ratedAnimeImage;
    }

    public void setRatedAnimeImage(String ratedAnimeImage) {
        this.ratedAnimeImage = ratedAnimeImage;
    }

    public int getRatedAnimeRating() {
        return ratedAnimeRating;
    }

    public void setRatedAnimeRating(int ratedAnimeRating) {
        this.ratedAnimeRating = ratedAnimeRating;
    }

    public long getRatedAnimeDescription() {
        return ratedAnimeDescription;
    }

    public void setRatedAnimeDescription(long ratedAnimeDescription) {
        this.ratedAnimeDescription = ratedAnimeDescription;
    }

    @Override
    public String toString() {
        return "RatedAnime [ratedAnimeID=" + ratedAnimeID + ", ratedAnimeCustomID=" + ratedAnimeCustomID + ", ratedAnimeName="
                + ratedAnimeName + ", ratedAnimeImage=" + ratedAnimeImage + ", ratedAnimeRating=" + ratedAnimeRating
                + ", ratedAnimeDescription=" + ratedAnimeDescription + "]";
    }
}
