package com.example.TVMediaReview.repository;

import com.example.TVMediaReview.model.RatedFilm;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RatedFilmRepository extends CrudRepository<RatedFilm, Long> {
	RatedFilm findByRatedFilmID(Long ratedFilmID);
	RatedFilm findByRatedFilmCustomID(String ratedFilmCustomID);
	

}
