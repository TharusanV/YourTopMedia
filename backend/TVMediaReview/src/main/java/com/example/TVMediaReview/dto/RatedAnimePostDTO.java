package com.example.TVMediaReview.dto;

public class RatedAnimePostDTO {

	String ratedAnimeCustomID;
	String ratedAnimeName;
	String ratedAnimeImage;
	int ratedAnimeRating;
	long ratedAnimeDescription;
	
	public RatedAnimePostDTO(String ratedAnimeCustomID, String ratedAnimeName, String ratedAnimeImage, int ratedAnimeRating, long ratedAnimeDescription) {
		super();
		this.ratedAnimeCustomID = ratedAnimeCustomID;
		this.ratedAnimeName = ratedAnimeName;
		this.ratedAnimeImage = ratedAnimeImage;
		this.ratedAnimeRating = ratedAnimeRating;
		this.ratedAnimeDescription = ratedAnimeDescription;
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
	

}
