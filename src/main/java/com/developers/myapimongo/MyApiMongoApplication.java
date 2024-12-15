package com.developers.myapimongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApiMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApiMongoApplication.class, args);
		System.out.println("------------------------------------------------------------------\n" +
				"Hello MongoDB\n" +
				"------------------------------------------------------------------");
	}

}
