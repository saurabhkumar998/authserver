package com.example.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class AuthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserverApplication.class, args);
	}

	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		var user1 = User.withDefaultPasswordEncoder()
				.password("pw")
				.username("test1")
				.roles("admin")
				.build();

		var user2 = User.withDefaultPasswordEncoder()
				.password("pw")
				.username("test2")
				.roles("user")
				.build();


		return new InMemoryUserDetailsManager(user1, user2);
	}
}
