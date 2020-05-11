package com.conferencedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@Value("${dbname}")
	private static String dbName;
	
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
