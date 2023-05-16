package com.ojas.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String showHome() {
		return "hi this is home";
	}

	@GetMapping("/welcome")
	public String showWelcome() {
		return "hi this is welcome";
	}

	@GetMapping("/admin")
	public String showAdmin() {
		return "hi this is admin";
	}

	@GetMapping("/emp")
	public String showEmp() {
		return "hi this is showEmp";
	}

	@GetMapping("/std")
	public String showStudent() {
		return "hi this is StudentPage";
	}

	@GetMapping("/denied")
	public String showDenied() {
		return "hi the network is bussy";
	}
}
