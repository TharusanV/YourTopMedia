package com.example.TVMediaReview.repository;


import com.example.TVMediaReview.model.RatedAnime;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RatedAnimeRepository extends CrudRepository<RatedAnime, Long>{

	RatedAnime findByRatedAnimeID(Long ratedAnimeID);
	RatedAnime findByRatedAnimeCustomID(String ratedAnimeCustomID);
}
