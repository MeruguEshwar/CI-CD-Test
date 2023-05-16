package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// System.out.println(pwdEnocder.decode($2a$10$tsfQKFjIcFpJ3zO4sTCU9OoDUPQ86R2hpUxcfjr4MVePu));
	}

}
