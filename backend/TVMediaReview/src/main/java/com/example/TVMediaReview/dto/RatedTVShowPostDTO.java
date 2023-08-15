package com.example.TVMediaReview.dto;

public class RatedTVShowPostDTO {
	String ratedTVShowCustomID;
	String ratedTVShowName;
	String ratedTVShowImage;
	int ratedTVShowRating;
	long ratedTVShowDescription;

	public RatedTVShowPostDTO(String ratedTVShowCustomID, String ratedTVShowName, String ratedTVShowImage, int ratedTVShowRating, long ratedTVShowDescription) {
		super();
		this.ratedTVShowCustomID = ratedTVShowCustomID;
		this.ratedTVShowName = ratedTVShowName;
		this.ratedTVShowImage = ratedTVShowImage;
		this.ratedTVShowRating = ratedTVShowRating;
		this.ratedTVShowDescription = ratedTVShowDescription;
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

}
