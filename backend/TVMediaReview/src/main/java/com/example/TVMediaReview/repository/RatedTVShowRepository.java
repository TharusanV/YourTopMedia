package com.example.TVMediaReview.repository;

import com.example.TVMediaReview.model.RatedTVShow;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RatedTVShowRepository extends CrudRepository<RatedTVShow, Long> {
	RatedTVShow findByRatedTVShowID(Long ratedTVShowID);
	RatedTVShow findByRatedTVShowCustomID(String ratedTVShowCustomID);
}
