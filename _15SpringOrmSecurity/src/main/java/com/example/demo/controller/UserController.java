package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.IuserService;
import com.example.demo.util.EmailUtil;

@RestController
public class UserController {

	@Autowired
	private IuserService userservice;
	
	@Autowired
	private EmailUtil emailutil;

	@PostMapping("/reg")
	public String showReg(@RequestBody User user) {
		Integer id = userservice.saveUser(user);
		String msg = null;

		if (id != null) {
			String messages = user.getName() + ",created with roles:" + user.getRoles();
			System.out.println("messages details is:" + messages);
			boolean sent = emailutil.send(user.getEmail(), "merugueshwar93@gmail.com", messages);
			System.out.println("sent details is:" + sent);
			if (messages != null) {
				msg += "email is also sent successfully";
			} else {
				msg += "email sending fail";
			}
			msg = "inserted successfully";
		}else {
			msg = "insertion of records is failed";
		}
		return msg;
	}

	@GetMapping("/test")
	public String testing() {
		return "hi am eeshwar";
	}

	@GetMapping("/home")
	public String homeController() {
		return "hi this is home controller";
	}

	@GetMapping("/welcome")
	public String welcomeController() {
		return "hi this is welcome controller";
	}

	@GetMapping("/admin")
	public String adminController() {
		return "hi this is admin controller";
	}

	@GetMapping("/emp")
	public String employeeController() {
		return "hi this is emp controller";
	}

	@GetMapping("/std")
	public String stdController() {
		return "hi this is std controller";
	}
}
