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
import com.example.TVMediaReview.model.RatedFilm;
import com.example.TVMediaReview.service.RatedFilmService;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
public class RatedFilmController {

    @Autowired
    RatedFilmService ratedFilmService;

    @GetMapping("/ratedFilms")
    public List<RatedFilm> getRatedFilms() {
        return ratedFilmService.getRatedFilms();
    }

    @PostMapping("/ratedFilms")
    public ResponseEntity<Optional<RatedFilm>> addRatedFilm(@RequestBody RatedFilmPostDTO newRatedFilmDTO) {

        if (newRatedFilmDTO.getRatedFilmName() == null) {
            return new ResponseEntity<>(Optional.ofNullable(null), HttpStatus.BAD_REQUEST);
        }

        RatedFilm newRatedFilm = new RatedFilm(newRatedFilmDTO.getRatedFilmCustomID(),
        		newRatedFilmDTO.getRatedFilmName(),
                newRatedFilmDTO.getRatedFilmImage(),
                newRatedFilmDTO.getRatedFilmRating(), 
                newRatedFilmDTO.getRatedFilmDescription());
        ratedFilmService.addRatedFilm(newRatedFilm);
        return new ResponseEntity<>(Optional.ofNullable(newRatedFilm), HttpStatus.CREATED);

    }
    
    
    

    //Get Film by ID
    @GetMapping("/ratedFilm/{ratedFilmID}")
    public Optional<RatedFilm> getRatedFilmByRatedFilmID(@PathVariable(value = "ratedFilmID") long ratedFilmID) {
        return ratedFilmService.findByRatedFilmID(ratedFilmID);
    }

    //Delete Film by ID
    @DeleteMapping("/ratedFilm/{ratedFilmID}")
    public String deleteRatedFilmByID(@PathVariable(value = "ratedFilmID") int RatedFilmID) {
        ratedFilmService.deleteRatedFilmByID(RatedFilmID);
        return "Film Deleted";
    }

    //Update Note by ID
    @PutMapping("/ratedFilm/updateRatedFilmByID/{ratedFilmID}")
    public RatedFilm updateRatedFilmByID(@PathVariable Long ratedFilmID, @RequestBody RatedFilm ratedFilm) {
        return ratedFilmService.updateRatedFilmByID(ratedFilmID, ratedFilm);
    }
    
    
    
    
    
    
    
    // Get Film by CustomID
    @GetMapping("/ratedFilm/findByRatedFilmCustomID")
    public Optional<RatedFilm> getRatedFilmByCustomID(@RequestParam String ratedFilmCustomID) {
        return Optional.ofNullable(ratedFilmService.findByRatedFilmCustomID(ratedFilmCustomID));
    }

    // Update ratedFilm
    @PutMapping("/ratedFilm/updateByRatedFilmCustomID/{ratedFilmCustomID}")
    public RatedFilm updateRatedFilmByCustomID(@PathVariable String ratedFilmCustomID, @RequestBody RatedFilm ratedFilm) {
        return ratedFilmService.updateRatedFilmByRatedFilmCustomID(ratedFilmCustomID, ratedFilm);
    }

    // Delete a ratedFilm by ratedFilmCustomID
    @DeleteMapping("/ratedFilm/deleteRatedFilmByRatedFilmCustomID/{ratedFilmCustomID}")
    public void deleteRatedFilmByRatedFilmCustomID(@PathVariable(value = "ratedFilmCustomID") String ratedFilmCustomID) {
        ratedFilmService.deleteRatedFilmByRatedFilmCustomID(ratedFilmCustomID);
    }

}
