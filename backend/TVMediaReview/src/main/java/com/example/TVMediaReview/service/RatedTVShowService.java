package com.example.TVMediaReview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TVMediaReview.model.RatedTVShow;
import com.example.TVMediaReview.repository.RatedTVShowRepository;
import com.example.TVMediaReview.exception.ResourceNotFoundException;

@Service
public class RatedTVShowService {
	@Autowired
	RatedTVShowRepository ratedTVShowRepository;

	public RatedTVShowService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<RatedTVShow> getRatedTVShows() {
		return (List<RatedTVShow>) ratedTVShowRepository.findAll();
	}

	public void addRatedTVShow(RatedTVShow newRatedTVShow) {
		ratedTVShowRepository.save(newRatedTVShow);
	}



	public Optional<RatedTVShow> findByRatedTVShowID(Long ratedTVShowID) {
		return ratedTVShowRepository.findById(ratedTVShowID);
	}

	public void deleteRatedTVShowByID(long ratedTVShowID) {
		RatedTVShow ratedTVShow = ratedTVShowRepository.findById(ratedTVShowID)
				.orElseThrow(() -> new ResourceNotFoundException("RatedTVShow", "ratedTVShowID", ratedTVShowID));
		ratedTVShowRepository.delete(ratedTVShow);
	}

	public RatedTVShow updateRatedTVShowByID(Long ratedTVShowID, RatedTVShow ratedTVShow) {
		RatedTVShow existingRatedTVShow = ratedTVShowRepository.findByRatedTVShowID(ratedTVShowID);
		existingRatedTVShow.setRatedTVShowCustomID(ratedTVShow.getRatedTVShowCustomID());
		existingRatedTVShow.setRatedTVShowName(ratedTVShow.getRatedTVShowName());
		existingRatedTVShow.setRatedTVShowImage(ratedTVShow.getRatedTVShowImage());
		existingRatedTVShow.setRatedTVShowRating(ratedTVShow.getRatedTVShowRating());
		existingRatedTVShow.setRatedTVShowDescription(ratedTVShow.getRatedTVShowDescription());
		return ratedTVShowRepository.save(existingRatedTVShow);
	}



	public RatedTVShow findByRatedTVShowCustomID(String ratedTVShowCustomID) {
		return ratedTVShowRepository.findByRatedTVShowCustomID(ratedTVShowCustomID);
	}


	public RatedTVShow updateRatedTVShowByRatedTVShowCustomID(String ratedTVShowCustomID, RatedTVShow ratedTVShow) {
		RatedTVShow existingRatedTVShow = ratedTVShowRepository.findByRatedTVShowCustomID(ratedTVShowCustomID);
		existingRatedTVShow.setRatedTVShowName(ratedTVShow.getRatedTVShowName());
		existingRatedTVShow.setRatedTVShowImage(ratedTVShow.getRatedTVShowImage());
		existingRatedTVShow.setRatedTVShowRating(ratedTVShow.getRatedTVShowRating());
		existingRatedTVShow.setRatedTVShowDescription(ratedTVShow.getRatedTVShowDescription());
		return ratedTVShowRepository.save(existingRatedTVShow);
	}

	public void deleteRatedTVShowByRatedTVShowCustomID(String ratedTVShowCustomID) {
		RatedTVShow existingRatedTVShow = ratedTVShowRepository.findByRatedTVShowCustomID(ratedTVShowCustomID);
		ratedTVShowRepository.delete(existingRatedTVShow);
	}


}
