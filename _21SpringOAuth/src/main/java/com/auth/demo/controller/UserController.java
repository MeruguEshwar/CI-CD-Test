package com.auth.demo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/test")
	public String test() {
		return "hi am eshwar";
	}
	
	@GetMapping("/user")
	public Principal user(Principal p) {
		System.out.println(p.getClass().getName());
		return p;
	}
}
