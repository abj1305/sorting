package com.practice.sorting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.practice.springboot.*"})
public class SortingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SortingApplication.class, args);
	}

}
