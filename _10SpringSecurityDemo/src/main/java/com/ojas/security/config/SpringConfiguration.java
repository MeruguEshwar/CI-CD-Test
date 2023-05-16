package com.ojas.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringConfiguration extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity httpsecurity) throws Exception {
		//URL-AccessType
		httpsecurity.authorizeHttpRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/std").hasAuthority("STUDENT")
				
		//login form details
		.and()
		.formLogin()
		
		
		//logout details
		.and()
		.httpBasic()
		
		//exception details
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Admin").password("Admin@123").authorities("ADMIN").
		and().withUser("rani").password("rani@123").authorities("STUDENT").
		and().passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

}
