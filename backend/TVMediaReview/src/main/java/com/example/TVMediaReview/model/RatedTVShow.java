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
@Table(name = "RatedTVShows")
@EntityListeners(AuditingEntityListener.class)
public class RatedTVShow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ratedTVShowID;

	String ratedTVShowCustomID;

	@NotBlank
	String ratedTVShowName;

	String ratedTVShowImage;

	int ratedTVShowRating;

	long ratedTVShowDescription;

	public RatedTVShow() {

	}

	public RatedTVShow(String ratedTVShowCustomID, @NotBlank String ratedTVShowName, String ratedTVShowImage, int ratedTVShowRating, long ratedTVShowDescription) {
		super();
		this.ratedTVShowCustomID = ratedTVShowCustomID;
		this.ratedTVShowName = ratedTVShowName;
		this.ratedTVShowImage = ratedTVShowImage;
		this.ratedTVShowRating = ratedTVShowRating;
		this.ratedTVShowDescription = ratedTVShowDescription;
	}

	public Long getRatedTVShowID() {
		return ratedTVShowID;
	}

	public void setRatedTVShowID(Long ratedTVShowID) {
		this.ratedTVShowID = ratedTVShowID;
	}

	public String getRatedTVShowCustomID() {
		return ratedTVShowCustomID;
	}

	public void setRatedTVShowCustomID(String ratedTVShowCustomID) {
		this.ratedTVShowCustomID = ratedTVShowCustomID;
	}

	public String getRatedTVShowName() {
		return ratedTVShowName;
	}

	public void setRatedTVShowName(String ratedTVShowName) {
		this.ratedTVShowName = ratedTVShowName;
	}

	public String getRatedTVShowImage() {
		return ratedTVShowImage;
	}

	public void setRatedTVShowImage(String ratedTVShowImage) {
		this.ratedTVShowImage = ratedTVShowImage;
	}

	public int getRatedTVShowRating() {
		return ratedTVShowRating;
	}

	public void setRatedTVShowRating(int ratedTVShowRating) {
		this.ratedTVShowRating = ratedTVShowRating;
	}

	public long getRatedTVShowDescription() {
		return ratedTVShowDescription;
	}

	public void setRatedTVShowDescription(long ratedTVShowDescription) {
		this.ratedTVShowDescription = ratedTVShowDescription;
	}

	@Override
	public String toString() {
		return "RatedTVShow [ratedTVShowID=" + ratedTVShowID + ", ratedTVShowCustomID=" + ratedTVShowCustomID + ", ratedTVShowName="
				+ ratedTVShowName + ", ratedTVShowImage=" + ratedTVShowImage + ", ratedTVShowRating=" + ratedTVShowRating
				+ ", ratedTVShowDescription=" + ratedTVShowDescription + "]";
	}
}
