package com.katebarber.legos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.katebarber.legos.models.Lego;


@Repository
public interface LegoRepository extends CrudRepository<Lego, Long> {
	List<Lego> findAll();
}

