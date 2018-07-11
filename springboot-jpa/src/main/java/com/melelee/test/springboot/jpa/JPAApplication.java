package com.melelee.test.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class JPAApplication {

	public static void main(String[] args) {
		SpringApplication.run(JPAApplication.class, args);
	}

	@Bean
	public RestTemplate newRestTemplate(){
		return new RestTemplate();
	}
}
