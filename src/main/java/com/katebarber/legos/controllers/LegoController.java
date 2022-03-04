package com.katebarber.legos.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.katebarber.legos.models.Lego;
import com.katebarber.legos.models.Rating;
import com.katebarber.legos.models.User;
import com.katebarber.legos.services.LegoService;
import com.katebarber.legos.services.RatingService;
import com.katebarber.legos.services.UserService;


@Controller
public class LegoController {

	@Autowired
	private LegoService legoService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		List<Lego> lego = legoService.allLegos();
		model.addAttribute("legos", lego);
		User user = userService.oneUser((Long)session.getAttribute("userId"));
		model.addAttribute("userName", user.getUserName());
	
		return "dashboard.jsp";
	}
	
	// CREATE
    @GetMapping("/legos/new")
    public String createLegoForm(@ModelAttribute("lego") Lego lego, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
    	return "createLego.jsp";
    }
    
	@PostMapping("/legos/new")
	public String createLegoProcess(@Valid @ModelAttribute("lego")Lego lego, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {	
			return "createLego.jsp";
			
		} else {
			
			legoService.createLego(lego);
			return "redirect:/dashboard";
		}
	}
    
    
    // GET ONE
	@GetMapping("/legos/{id}")
	public String getOneLego(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		model.addAttribute("rating", new Rating());
		Lego lego = legoService.oneLego(id);
		model.addAttribute("lego", lego);
		List<Rating> rating = ratingService.allRatingsLegos(lego);
		model.addAttribute("ratings", rating);
		
		return "showOneLego.jsp";
	}
    
    
    // EDIT
	@GetMapping("/legos/edit/{id}")
	public String editLegoForm(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Lego lego = legoService.oneLego(id);
		model.addAttribute("lego", lego);
		return "editLego.jsp";
	}
	
	@PutMapping("/legos/edit/{id}")
	public String editLegoProcess(@Valid @ModelAttribute("lego")Lego lego, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {		
			return "editLego.jsp";
			
		}else {
			
			legoService.updateLego(lego);
			return "redirect:/dashboard";
		}
	}
    
    // DELETE
	@DeleteMapping("/legos/{id}")
	public String deleteLego(@PathVariable("id")Long id) {
		legoService.deleteLego(id);
		return "redirect:/dashboard";
	}
	
}
