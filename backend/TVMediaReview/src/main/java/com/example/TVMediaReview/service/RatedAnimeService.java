package com.example.TVMediaReview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TVMediaReview.model.RatedAnime;
import com.example.TVMediaReview.repository.RatedAnimeRepository;
import com.example.TVMediaReview.exception.ResourceNotFoundException;


@Service
public class RatedAnimeService {

	@Autowired
	RatedAnimeRepository ratedAnimeRepository;

	public RatedAnimeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<RatedAnime> getRatedAnimes() {
		return (List<RatedAnime>) ratedAnimeRepository.findAll();
	}

	public void addRatedAnime(RatedAnime newRatedAnime) {
		ratedAnimeRepository.save(newRatedAnime);
	}

	public Optional<RatedAnime> findByRatedAnimeID(Long ratedAnimeID) {
		return ratedAnimeRepository.findById(ratedAnimeID);
	}

	public void deleteRatedAnimeByID(long ratedAnimeID) {
		RatedAnime ratedAnime = ratedAnimeRepository.findById(ratedAnimeID)
				.orElseThrow(() -> new ResourceNotFoundException("RatedAnime", "ratedAnimeID", ratedAnimeID));
		ratedAnimeRepository.delete(ratedAnime);
	}

	public RatedAnime updateRatedAnimeByID(Long ratedAnimeID, RatedAnime ratedAnime) {
		RatedAnime existingRatedAnime = ratedAnimeRepository.findByRatedAnimeID(ratedAnimeID);
		existingRatedAnime.setRatedAnimeCustomID(ratedAnime.getRatedAnimeCustomID());
		existingRatedAnime.setRatedAnimeName(ratedAnime.getRatedAnimeName());
		existingRatedAnime.setRatedAnimeImage(ratedAnime.getRatedAnimeImage());
		existingRatedAnime.setRatedAnimeRating(ratedAnime.getRatedAnimeRating());
		existingRatedAnime.setRatedAnimeDescription(ratedAnime.getRatedAnimeDescription());
		return ratedAnimeRepository.save(existingRatedAnime);
	}

	public RatedAnime findByRatedAnimeCustomID(String ratedAnimeCustomID) {
		return ratedAnimeRepository.findByRatedAnimeCustomID(ratedAnimeCustomID);
	}

	public RatedAnime updateRatedAnimeByRatedAnimeCustomID(String ratedAnimeCustomID, RatedAnime ratedAnime) {
		RatedAnime existingRatedAnime = ratedAnimeRepository.findByRatedAnimeCustomID(ratedAnimeCustomID);
		existingRatedAnime.setRatedAnimeName(ratedAnime.getRatedAnimeName());
		existingRatedAnime.setRatedAnimeImage(ratedAnime.getRatedAnimeImage());
		existingRatedAnime.setRatedAnimeRating(ratedAnime.getRatedAnimeRating());
		existingRatedAnime.setRatedAnimeDescription(ratedAnime.getRatedAnimeDescription());
		return ratedAnimeRepository.save(existingRatedAnime);
	}

	public void deleteRatedAnimeByRatedAnimeCustomID(String ratedAnimeCustomID) {
		RatedAnime existingRatedAnime = ratedAnimeRepository.findByRatedAnimeCustomID(ratedAnimeCustomID);
		ratedAnimeRepository.delete(existingRatedAnime);
	}
}
