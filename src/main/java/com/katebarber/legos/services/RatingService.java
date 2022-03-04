package com.katebarber.legos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.katebarber.legos.models.Lego;
import com.katebarber.legos.models.Rating;
import com.katebarber.legos.repositories.RatingRepository;


@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;
	
	//READ - GET ALL
	public List<Rating> allRatings() {
		return ratingRepo.findAll();
	}

	//READ - GET ONE;
	public Rating oneRating(Long ratingId) {
		Optional<Rating> optionalRating = ratingRepo.findById(ratingId);
		
		if (optionalRating.isPresent()) {
			return optionalRating.get();
			
		} else {
			return null;
		}
	}
	
	//READ - GET ALL
	public List<Rating> allRatingsLegos(Lego lego) {
		return ratingRepo.findByLego(lego);
	}
	
	//CREATE
	public Rating createRating(Rating rating) {
		return ratingRepo.save(rating);
	}
		
	//UPDATE
	public Rating updateRating(Rating rating) {
		return ratingRepo.save(rating);
	}
	
	//DELETE
	public void deleteRating(Long id) {
		ratingRepo.deleteById(id);
	}


}
