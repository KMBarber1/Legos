package com.katebarber.legos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.katebarber.legos.models.Lego;
import com.katebarber.legos.models.Rating;

import com.katebarber.legos.services.LegoService;
import com.katebarber.legos.services.RatingService;


@Controller
public class RatingController {

	@Autowired
	private LegoService legoService;
	
	@Autowired
	private RatingService ratingService;

	
	// CREATE
	@PostMapping("/ratings/{legoId}")
	public String createRatingProcess(@Valid @ModelAttribute("rating")Rating rating, BindingResult result, @PathVariable("legoId")Long legoId, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {	
			Lego lego = legoService.oneLego(legoId);
			model.addAttribute("lego", lego);
			return "showOneLego.jsp";
			
		} else {
			/* System.out.println("********************************"); */
			ratingService.createRating(rating);
			return "redirect:/dashboard";
		}
	}
	
}