package com.klu.jfsd.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JarApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarApplication.class, args);
		System.out.println("Hello");
	}

}
