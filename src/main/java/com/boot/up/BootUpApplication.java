package com.boot.up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BootUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootUpApplication.class, args);
	}

}
