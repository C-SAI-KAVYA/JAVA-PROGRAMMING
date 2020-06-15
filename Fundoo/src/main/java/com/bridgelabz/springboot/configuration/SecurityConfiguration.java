package com.bridgelabz.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public BCryptPasswordEncoder bcpe() {
		return new BCryptPasswordEncoder();
	}
}
