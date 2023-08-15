package com.example.TVMediaReview.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TVMediaReview.dto.*;
import com.example.TVMediaReview.model.RatedTVShow;
import com.example.TVMediaReview.service.RatedTVShowService;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
public class RatedTVShowController {
	@Autowired
	RatedTVShowService ratedTVShowService;

	@GetMapping("/ratedTVShows")
	public List<RatedTVShow> getRatedTVShows() {
	    return ratedTVShowService.getRatedTVShows();
	}

	@PostMapping("/ratedTVShows")
	public ResponseEntity<Optional<RatedTVShow>> addRatedTVShow(@RequestBody RatedTVShowPostDTO newRatedTVShowDTO) {

	    if (newRatedTVShowDTO.getRatedTVShowName() == null) {
	        return new ResponseEntity<>(Optional.ofNullable(null), HttpStatus.BAD_REQUEST);
	    }

	    RatedTVShow newRatedTVShow = new RatedTVShow(newRatedTVShowDTO.getRatedTVShowCustomID(),
	    		newRatedTVShowDTO.getRatedTVShowName(),
	            newRatedTVShowDTO.getRatedTVShowImage(),
	            newRatedTVShowDTO.getRatedTVShowRating(), 
	            newRatedTVShowDTO.getRatedTVShowDescription());
	    ratedTVShowService.addRatedTVShow(newRatedTVShow);
	    return new ResponseEntity<>(Optional.ofNullable(newRatedTVShow), HttpStatus.CREATED);

	}




	//Get TV Show by ID
	@GetMapping("/ratedTVShow/{ratedTVShowID}")
	public Optional<RatedTVShow> getRatedTVShowByRatedTVShowID(@PathVariable(value = "ratedTVShowID") long ratedTVShowID) {
	    return ratedTVShowService.findByRatedTVShowID(ratedTVShowID);
	}

	//Delete TV Show by ID
	@DeleteMapping("/ratedTVShow/{ratedTVShowID}")
	public String deleteRatedTVShowByID(@PathVariable(value = "ratedTVShowID") int ratedTVShowID) {
	    ratedTVShowService.deleteRatedTVShowByID(ratedTVShowID);
	    return "TV Show Deleted";
	}

	//Update TV Show by ID
	@PutMapping("/ratedTVShow/updateRatedTVShowByID/{ratedTVShowID}")
	public RatedTVShow updateRatedTVShowByID(@PathVariable Long ratedTVShowID, @RequestBody RatedTVShow ratedTVShow) {
	    return ratedTVShowService.updateRatedTVShowByID(ratedTVShowID, ratedTVShow);
	}
	
	
	
	
	

	// Get TV Show by CustomID
	@GetMapping("/ratedTVShow/findByRatedTVShowCustomID")
	public Optional<RatedTVShow> getRatedTVShowByCustomID(@RequestParam String ratedTVShowCustomID) {
	    return Optional.ofNullable(ratedTVShowService.findByRatedTVShowCustomID(ratedTVShowCustomID));
	}

	// Update TV Show
	@PutMapping("/ratedTVShow/updateByRatedTVShowCustomID/{ratedTVShowCustomID}")
	public RatedTVShow updateRatedTVShowByCustomID(@PathVariable String ratedTVShowCustomID, @RequestBody RatedTVShow ratedTVShow) {
	    return ratedTVShowService.updateRatedTVShowByRatedTVShowCustomID(ratedTVShowCustomID, ratedTVShow);
	}

	// Delete a TV Show by ratedTVShowCustomID
	@DeleteMapping("/ratedTVShow/deleteRatedTVShowByRatedTVShowCustomID/{ratedTVShowCustomID}")
	public void deleteRatedTVShowByRatedTVShowCustomID(@PathVariable(value = "ratedTVShowCustomID") String ratedTVShowCustomID) {
	    ratedTVShowService.deleteRatedTVShowByRatedTVShowCustomID(ratedTVShowCustomID);
	}


}
