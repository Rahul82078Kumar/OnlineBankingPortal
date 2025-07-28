package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/","/login**","/oauth2/**").permitAll()
				.anyRequest().authenticated()
				)
		
				.oauth2Login(oauth2->oauth2
						.defaultSuccessUrl("/welcome",true)
						
						);
		
		return http.build();
	}


}
