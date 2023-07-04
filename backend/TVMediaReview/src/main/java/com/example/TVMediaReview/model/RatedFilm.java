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
@Table(name = "RatedFilms")
@EntityListeners(AuditingEntityListener.class)
public class RatedFilm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ratedFilmID;
	
	int ratedFilmCustomID;

	@NotBlank
	String ratedFilmName;
	
	String ratedFilmImage;

	int ratedFilmRating;

	long ratedFilmDescription;

	public RatedFilm() {

	}

	public RatedFilm(int ratedFilmCustomID, @NotBlank String ratedFilmName, String ratedFilmImage, int ratedFilmRating, long ratedFilmDescription) {
		super();
		this.ratedFilmCustomID = ratedFilmCustomID;
		this.ratedFilmName = ratedFilmName;
		this.ratedFilmImage = ratedFilmImage;
		this.ratedFilmRating = ratedFilmRating;
		this.ratedFilmDescription = ratedFilmDescription;
	}

	public Long getRatedFilmID() {
		return ratedFilmID;
	}

	public void setRatedFilmID(Long ratedFilmID) {
		this.ratedFilmID = ratedFilmID;
	}

	public int getRatedFilmCustomID() {
		return ratedFilmCustomID;
	}

	public void setRatedFilmCustomID(int ratedFilmCustomID) {
		this.ratedFilmCustomID = ratedFilmCustomID;
	}

	public String getRatedFilmName() {
		return ratedFilmName;
	}

	public void setRatedFilmName(String ratedFilmName) {
		this.ratedFilmName = ratedFilmName;
	}

	public String getRatedFilmImage() {
		return ratedFilmImage;
	}

	public void setRatedFilmImage(String ratedFilmImage) {
		this.ratedFilmImage = ratedFilmImage;
	}

	public int getRatedFilmRating() {
		return ratedFilmRating;
	}

	public void setRatedFilmRating(int ratedFilmRating) {
		this.ratedFilmRating = ratedFilmRating;
	}

	public long getRatedFilmDescription() {
		return ratedFilmDescription;
	}

	public void setRatedFilmDescription(long ratedFilmDescription) {
		this.ratedFilmDescription = ratedFilmDescription;
	}

	@Override
	public String toString() {
		return "RatedFilm [ratedFilmID=" + ratedFilmID + ", ratedFilmCustomID=" + ratedFilmCustomID + ", ratedFilmName="
				+ ratedFilmName + ", ratedFilmImage=" + ratedFilmImage + ", ratedFilmRating=" + ratedFilmRating
				+ ", ratedFilmDescription=" + ratedFilmDescription + "]";
	}



}