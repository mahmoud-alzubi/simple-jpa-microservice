package com.example.crudjpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.example"})
public class CrudJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJpaExampleApplication.class, args);
	}

}
