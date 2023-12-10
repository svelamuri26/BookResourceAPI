package com.example.BookResourcedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.BookResourcedemo")
public class BookResourcedemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookResourcedemoApplication.class, args);
	}

}
