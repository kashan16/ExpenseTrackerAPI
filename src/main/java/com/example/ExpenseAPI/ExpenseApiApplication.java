package com.example.ExpenseAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseApiApplication.class, args);
		System.out.println("Server running.....");
	}

}
