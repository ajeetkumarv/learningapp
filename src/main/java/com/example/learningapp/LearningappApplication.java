package com.example.learningapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class LearningappApplication {

	private static final Logger logger = LoggerFactory.getLogger(LearningappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearningappApplication.class, args);
	}

}
