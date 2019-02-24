package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(@RequestParam (value="error",required=false) String error
			,@RequestParam(value="logout",required=false) String logout
			,Model model) {
		
		String errorMessage=null;
		
		if(error!=null) {
			System.out.println("Username and Password is incorrect !!");
			errorMessage="Username and Password is incorrect !!";
		}if(logout!=null) {
			System.out.println("You have been successfully logout !!");
			errorMessage="You have been successfully logout !!";
		}
		model.addAttribute("errorMessage",errorMessage);
		
		return "UserLogin";
	}
	
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutPage(HttpServletRequest req,HttpServletResponse res) {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(req,res,auth);
		}
		return "redirect:/login?logout=true";
	}
	
	@RequestMapping("/denied")
	public String deniedPage() {
		return "AccessDenied";
	}
	
}
