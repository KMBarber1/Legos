package com.katebarber.legos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.katebarber.legos.models.Lego;
import com.katebarber.legos.repositories.LegoRepository;


@Service
public class LegoService {
	
	@Autowired
	private LegoRepository legoRepo;
	
	//READ - GET ALL
	public List<Lego> allLegos() {
		return legoRepo.findAll();
	}

	//READ - GET ONE;
	public Lego oneLego(Long legoId) {
		Optional<Lego> optionalLego = legoRepo.findById(legoId);
		
		if (optionalLego.isPresent()) {
			return optionalLego.get();
			
		} else {
			return null;
		}
	}
	
	//CREATE
	public Lego createLego(Lego lego) {
		return legoRepo.save(lego);
	}
		
	//UPDATE
	public Lego updateLego(Lego lego) {
		return legoRepo.save(lego);
	}
	
	//DELETE
	public void deleteLego(Long id) {
		legoRepo.deleteById(id);
	}


	
}