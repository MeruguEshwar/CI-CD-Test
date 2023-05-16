package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements IuserService, UserDetailsService {

	@Autowired
	private UserRepo userepo;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Override
	public Integer saveUser(User user) {

		String pwd = user.getPwd();

		user.setPwd(pwdEncoder.encode(user.getPwd()));

		//save password
		user = userepo.save(user);
		return user.getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// load model class user object by emaild(username)
		Optional<User> opt = userepo.findByEmail(username);
		org.springframework.security.core.userdetails.User us = null;

		if (opt.isEmpty()) {
			// if username not prescent throw exception
			throw new UsernameNotFoundException("Username is not found:" + username);
		} else {
			// if prescent
			User user = opt.get();

			List<String> roles = user.getRoles();

			Set<GrantedAuthority> gas = new HashSet<>();

			for (String role : roles) {
				gas.add(new SimpleGrantedAuthority(role));
			}

			// Convert user model object into security model object
			us = new org.springframework.security.core.userdetails.User(username, user.getPwd(), gas);
		}
		return us;
	}

}
