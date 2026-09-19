// PersonalexpensetrackerApplication.java
package com.maurodelcore.personalexpensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Personal Expense Tracker REST API.
 *
 * <p>A Spring Boot application that loads expense data from a JSON file
 * and exposes GET endpoints for listing and filtering transactions
 * by date, category, and payment account.</p>
 *
 * <p>Built as part of the Denis Panjuta 60-Day Java Masterclass — Day 41:
 * JSON Processing and Lombok Annotations.</p>
 *
 */
@SpringBootApplication
public class PersonalexpensetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalexpensetrackerApplication.class, args);
	}
}