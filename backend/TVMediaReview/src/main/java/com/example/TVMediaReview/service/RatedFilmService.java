package com.example.TVMediaReview.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TVMediaReview.model.RatedFilm;
import com.example.TVMediaReview.repository.RatedFilmRepository;
import com.example.TVMediaReview.exception.ResourceNotFoundException;

@Service
public class RatedFilmService {

	@Autowired
	RatedFilmRepository ratedFilmRepository;

	public RatedFilmService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<RatedFilm> getRatedFilms() {
		return (List<RatedFilm>) ratedFilmRepository.findAll();
	}

	public void addRatedFilm(RatedFilm newRatedFilm) {
		ratedFilmRepository.save(newRatedFilm);
	}

	
	
	public Optional<RatedFilm> findByRatedFilmID(Long ratedFilmID) {
		return ratedFilmRepository.findById(ratedFilmID);
	}

	public void deleteRatedFilmByID(long ratedFilmID) {
		RatedFilm ratedFilm = ratedFilmRepository.findById(ratedFilmID)
				.orElseThrow(() -> new ResourceNotFoundException("RatedFilm", "ratedFilmID", ratedFilmID));
		ratedFilmRepository.delete(ratedFilm);
	}

	public RatedFilm updateRatedFilmByID(Long ratedFilmID, RatedFilm ratedFilm) {
		RatedFilm existingRatedFilm = ratedFilmRepository.findByRatedFilmID(ratedFilmID);
		existingRatedFilm.setRatedFilmCustomID(ratedFilm.getRatedFilmCustomID());
		existingRatedFilm.setRatedFilmName(ratedFilm.getRatedFilmName());
		existingRatedFilm.setRatedFilmImage(ratedFilm.getRatedFilmImage());
		existingRatedFilm.setRatedFilmRating(ratedFilm.getRatedFilmRating());
		existingRatedFilm.setRatedFilmDescription(ratedFilm.getRatedFilmDescription());
		return ratedFilmRepository.save(existingRatedFilm);
	}
	
	
	
	public RatedFilm findByRatedFilmCustomID(String ratedFilmCustomID) {
		return ratedFilmRepository.findByRatedFilmCustomID(ratedFilmCustomID);
	}


	public RatedFilm updateRatedFilmByRatedFilmCustomID(String ratedFilmCustomID, RatedFilm ratedFilm) {
		RatedFilm existingRatedFilm = ratedFilmRepository.findByRatedFilmCustomID(ratedFilmCustomID);
		existingRatedFilm.setRatedFilmName(ratedFilm.getRatedFilmName());
		existingRatedFilm.setRatedFilmImage(ratedFilm.getRatedFilmImage());
		existingRatedFilm.setRatedFilmRating(ratedFilm.getRatedFilmRating());
		existingRatedFilm.setRatedFilmDescription(ratedFilm.getRatedFilmDescription());
		return ratedFilmRepository.save(existingRatedFilm);
	}

	public void deleteRatedFilmByRatedFilmCustomID(String ratedFilmCustomID) {
		RatedFilm existingRatedFilm = ratedFilmRepository.findByRatedFilmCustomID(ratedFilmCustomID);
		ratedFilmRepository.delete(existingRatedFilm);
	}
	
	
	
	


}
