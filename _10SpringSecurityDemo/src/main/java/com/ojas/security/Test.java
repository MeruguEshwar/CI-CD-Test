package com.ojas.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		String name = bc.encode("eshwar");
		System.out.println("Encodede pass is:"+name);
	}

}
