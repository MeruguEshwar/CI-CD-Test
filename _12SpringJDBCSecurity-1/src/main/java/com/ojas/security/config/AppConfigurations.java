package com.ojas.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
@Configuration
public class AppConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userdetailservice;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userdetailservice).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// URL-AccessType
		http.authorizeHttpRequests()
		.antMatchers("/home","/reg").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/std").hasAnyAuthority("ADMIN","EMPLOYEE")
		.anyRequest().authenticated()

				// login form details
				.and()
				.formLogin()
				.defaultSuccessUrl("/welcome",true)

				// logout details
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

				// exception details
				.and().exceptionHandling().accessDeniedPage("/denied");
	}
}
