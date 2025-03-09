package com.springtechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrudOperationsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationsDemoApplication.class, args);
	}

}
