package com.test.testdatagenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestdatageneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestdatageneratorApplication.class, args);
	}

}
