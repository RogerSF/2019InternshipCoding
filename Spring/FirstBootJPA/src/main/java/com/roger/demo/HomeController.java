package com.roger.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.roger.demo.dao.AlienRepo;
import com.roger.demo.model.Alien;

@RestController
public class HomeController {

	@Autowired
	AlienRepo repo;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("addAlien")
	public ModelAndView addAlien(Alien alien) {
		ModelAndView mv = new ModelAndView();
		repo.save(alien);
		mv.setViewName("home"); // it's only the view name, important operation is to insert in the database >....<
		return mv;
	}
	
	@GetMapping("getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int aid ) {
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject("alien", alien);
		System.out.println(repo.findByTech("Java"));
		// repo.deleteAll();
		// repo.
		mv.setViewName("show");
		return mv;
	}
	
	@GetMapping(path="aliens") // , produces={"application/json"}
	@ResponseBody
	public List<Alien> aliens() {
		return repo.findAll();
	}
	
	@GetMapping("alien/{aid}")
	@ResponseBody // instead of returning a file path, return a content.response directly
	public Alien aliens(@PathVariable("aid") int aid) {
		return repo.findById(aid).orElse(new Alien());
	}
	
	@PostMapping(path="/alien", consumes= {"application/json"})
	public Alien acceptAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("alien/{aid}")
	public Alien deleteAlien(@PathVariable int aid) {
		Alien a = repo.findById(aid).orElse(null);
		repo.deleteById(aid);
		return a;
	}
	
	@PutMapping("alien")
	public Alien putAlien(@RequestBody Alien alien) {
		//don't need to verify whether the aid exists, save does it all!
		//		if (repo.existsById(alien.getAid())) {
		//			repo.deleteById(alien.getAid());
		//		}
		repo.save(alien);
		return alien;
	}
	
}
