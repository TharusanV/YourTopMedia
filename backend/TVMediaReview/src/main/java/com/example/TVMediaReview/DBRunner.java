package com.example.TVMediaReview;

import com.example.TVMediaReview.model.*;
import com.example.TVMediaReview.repository.*;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DBRunner implements CommandLineRunner{
	@Autowired 
	private RatedFilmRepository ratedFilmRepository;
	
	@Override
	 public void run(String... args) throws Exception {		
		
	}
}