package com.katebarber.legos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.katebarber.legos.models.Lego;
import com.katebarber.legos.models.Rating;


@Repository
public interface RatingRepository extends CrudRepository<Rating, Long > {
	List<Rating> findAll();

	List<Rating> findByLego (Lego lego);
}
