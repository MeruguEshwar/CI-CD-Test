package com.ojas.security.service;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ojas.security.config.EncodingConfiguration;
import com.ojas.security.model.User;
import com.ojas.security.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	@Override
	public Integer saveUser(User user) {
		String pwd = user.getPwd();
		String encPwd = pwdEncoder.encode(pwd);
		user.setPwd(encPwd);
		
		User users = userepo.save(user);
		return users.getUid();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// load Model class user object by emailid(username)
		Optional<User> opt = userepo.findByEmail(username);
		org.springframework.security.core.userdetails.User usr = null;

		if (opt.isEmpty()) {
			throw new UsernameNotFoundException("username not found" + username);
		} else {
			User user = opt.get();

//			List<String> roles = user.getRoles();
//			Set<GrantedAuthority> gas = new HashSet<>();
//			for (String role : roles) {
//				gas.add(new SimpleGrantedAuthority(role));
//			}

			usr = new org.springframework.security.core.userdetails.User(username, 
					user.getPwd(),
					user.getRoles()
					.stream().map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toSet()));
		}

		return usr;
	}

}
