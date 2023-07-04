package com.example.TVMediaReview.dto;

public class RatedFilmPostDTO {

	int ratedFilmCustomID;
	String ratedFilmName;
	String ratedFilmImage;
	int ratedFilmRating;
	long ratedFilmDescription;
	
	public RatedFilmPostDTO(int ratedFilmCustomID, String ratedFilmName, String ratedFilmImage, int ratedFilmRating, long ratedFilmDescription) {
		super();
		this.ratedFilmCustomID = ratedFilmCustomID;
		this.ratedFilmName = ratedFilmName;
		this.ratedFilmImage = ratedFilmImage;
		this.ratedFilmRating = ratedFilmRating;
		this.ratedFilmDescription = ratedFilmDescription;
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
	

}
