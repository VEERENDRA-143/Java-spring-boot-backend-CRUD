package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
@RestController
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);

	}

	@GetMapping
	public String getMethodName() {
		return "Hello";
	}
	
}
