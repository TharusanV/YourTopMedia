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
import com.example.TVMediaReview.model.RatedAnime;
import com.example.TVMediaReview.service.RatedAnimeService;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
public class RatedAnimeController {

    @Autowired
    RatedAnimeService ratedAnimeService;

    @GetMapping("/ratedAnimes")
    public List<RatedAnime> getRatedAnimes() {
        return ratedAnimeService.getRatedAnimes();
    }

    @PostMapping("/ratedAnimes")
    public ResponseEntity<Optional<RatedAnime>> addRatedAnime(@RequestBody RatedAnimePostDTO newRatedAnimeDTO) {

        if (newRatedAnimeDTO.getRatedAnimeName() == null) {
            return new ResponseEntity<>(Optional.ofNullable(null), HttpStatus.BAD_REQUEST);
        }

        RatedAnime newRatedAnime = new RatedAnime(newRatedAnimeDTO.getRatedAnimeCustomID(),
        		newRatedAnimeDTO.getRatedAnimeName(),
                newRatedAnimeDTO.getRatedAnimeImage(),
                newRatedAnimeDTO.getRatedAnimeRating(), 
                newRatedAnimeDTO.getRatedAnimeDescription());
        ratedAnimeService.addRatedAnime(newRatedAnime);
        return new ResponseEntity<>(Optional.ofNullable(newRatedAnime), HttpStatus.CREATED);

    }
    
    //Get Anime by ID
    @GetMapping("/ratedAnime/{ratedAnimeID}")
    public Optional<RatedAnime> getRatedAnimeByRatedAnimeID(@PathVariable(value = "ratedAnimeID") long ratedAnimeID) {
        return ratedAnimeService.findByRatedAnimeID(ratedAnimeID);
    }

    //Delete Anime by ID
    @DeleteMapping("/ratedAnime/{ratedAnimeID}")
    public String deleteRatedAnimeByID(@PathVariable(value = "ratedAnimeID") int RatedAnimeID) {
        ratedAnimeService.deleteRatedAnimeByID(RatedAnimeID);
        return "Anime Deleted";
    }

    //Update Anime by ID
    @PutMapping("/ratedAnime/updateRatedAnimeByID/{ratedAnimeID}")
    public RatedAnime updateRatedAnimeByID(@PathVariable Long ratedAnimeID, @RequestBody RatedAnime ratedAnime) {
        return ratedAnimeService.updateRatedAnimeByID(ratedAnimeID, ratedAnime);
    }
    
    // Get Anime by CustomID
    @GetMapping("/ratedAnime/findByRatedAnimeCustomID")
    public Optional<RatedAnime> getRatedAnimeByCustomID(@RequestParam String ratedAnimeCustomID) {
        return Optional.ofNullable(ratedAnimeService.findByRatedAnimeCustomID(ratedAnimeCustomID));
    }

    // Update ratedAnime
    @PutMapping("/ratedAnime/updateByRatedAnimeCustomID/{ratedAnimeCustomID}")
    public RatedAnime updateRatedAnimeByCustomID(@PathVariable String ratedAnimeCustomID, @RequestBody RatedAnime ratedAnime) {
        return ratedAnimeService.updateRatedAnimeByRatedAnimeCustomID(ratedAnimeCustomID, ratedAnime);
    }

    // Delete an anime by ratedAnimeCustomID
    @DeleteMapping("/ratedAnime/deleteRatedAnimeByRatedAnimeCustomID/{ratedAnimeCustomID}")
    public void deleteRatedAnimeByRatedAnimeCustomID(@PathVariable(value = "ratedAnimeCustomID") String ratedAnimeCustomID) {
        ratedAnimeService.deleteRatedAnimeByRatedAnimeCustomID(ratedAnimeCustomID);
    }

}
