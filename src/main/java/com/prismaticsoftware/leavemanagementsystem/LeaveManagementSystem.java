package com.prismaticsoftware.leavemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LeaveManagementSystem {

	public static void main(String[] args) {

		SpringApplication.run(LeaveManagementSystem.class, args);
	}

//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return NoOpPasswordEncoder.getInstance();
//	}

}
