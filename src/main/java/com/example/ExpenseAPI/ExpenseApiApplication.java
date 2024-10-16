package com.example.ExpenseAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ExpenseApiApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		System.setProperty("DATABASE_URL",dotenv.get("DATABASE_URL"));
		System.setProperty("DATABASE_USERNAME",dotenv.get("DATABASE_USERNAME"));
		System.setProperty("DATABASE_PASSWORD",dotenv.get("DATABASE_PASSWORD"));
		System.out.println("Using Database URL: " + dotenv.get("DATABASE_URL"));
		
		SpringApplication.run(ExpenseApiApplication.class, args);
		System.out.println("Server running.....");
	}

}
