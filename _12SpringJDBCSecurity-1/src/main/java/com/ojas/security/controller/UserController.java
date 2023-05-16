package com.ojas.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.security.model.User;
import com.ojas.security.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userservice;
	
	
	@GetMapping("/reg")
	public String showReg() {
		return "user";
	}
	
	@PostMapping("/save")
	public String saveUser(
			@ModelAttribute User user,//take the data from the user
			Model model) {//render on to the ui
		
		Integer id = userservice.saveUser(user);
		
		String msg = "User saved"+id;
		
		model.addAttribute("message",msg);
		
		return "user";
	}
}
