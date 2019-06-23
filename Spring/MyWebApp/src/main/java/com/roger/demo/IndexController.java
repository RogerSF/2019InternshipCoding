package com.roger.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	/**
	 *  Naive implementation of MVC; not Spring boot style
	@RequestMapping("index")
	public String index(@RequestParam("name") String name, HttpSession session) {
		
		// session attributes are shared between VIEW & CONTROLLER		
		//  HttpSession session = request.getSession();
		// String name = request.getParameter("name");
		System.out.println("receive parameter name: " + name);
		session.setAttribute("name", name);
		return "Index";
	}
	 * 
	 */
	
	/**
	 *  Spring boot implementation of MVC, using ModelAndView
	 @RequestMapping("index")
	public ModelAndView index(@RequestParam("name") String name, @RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("id", id);
		mv.setViewName("Index");
		
		return mv;
	}
	 */
	
	@RequestMapping("index")
	public ModelAndView index(Alien alien, @RequestParam("date") String date) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("alienObj", alien);
		mv.addObject("date", date);
//		mv.addObject("alien2", alien2);
		mv.setViewName("Index");
		return mv;
		
	}
	
	
}
