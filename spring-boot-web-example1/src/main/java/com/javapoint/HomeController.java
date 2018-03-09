package com.javapoint;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static Logger log = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		
		ModelAndView  model =  new ModelAndView();
		model.addObject("title","spring security home page");
		model.addObject("message","this is the welcome page!!");
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		
		ModelAndView  model =  new ModelAndView();
		model.addObject("title","spring security admin page");
		model.addObject("message", "This is protected page!");		
		model.setViewName("admin");
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		
		
		if (auth !=  null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request,HttpServletResponse response) {
		
		log.debug("inside login");
		
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		
		
		if (auth !=  null) {
			
			Iterator<GrantedAuthority> authorityDetails = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
			
			while(authorityDetails.hasNext()) {
				
				System.out.println(authorityDetails.next().getAuthority());
			}
			
		}
		
		return "redirect:/login";
	}   
}
