package com.maurodelcore.personalexpensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonalexpensetrackerApplication {
	/**
	 * Personal Expense Tracker — Spring Boot REST API.
	 *
	 * <p>Loads dummy expense data from a JSON file into memory at startup
	 * using {@code @PostConstruct}. Provides GET-only endpoints for
	 * retrieving and filtering expenses by date, category, and account.</p>
	 *
	 * <h3>Data fields per expense:</h3>
	 * <ul>
	 *   <li>Expense type — income or expenditure (boolean/numeric flag)</li>
	 *   <li>Date — when the expense or income occurred</li>
	 *   <li>Amount — the amount spent or received</li>
	 *   <li>Category — e.g. groceries, utilities, salary</li>
	 *   <li>Account — source of funds (cash, bank, credit card)</li>
	 *   <li>Note — optional description</li>
	 * </ul>
	 *
	 * <h3>Architecture:</h3>
	 * <ul>
	 *   <li>Model — Lombok {@code @Data} class with Jackson annotations</li>
	 *   <li>Service — loads JSON file, handles filtering logic</li>
	 *   <li>PersonalExpenseController — GET endpoints only, delegates to service</li>
	 * </ul>
	 *
	 * <h3>Dependencies:</h3>
	 * Spring Web, Lombok
	 */

	public static void main(String[] args) {
		SpringApplication.run(PersonalexpensetrackerApplication.class, args);
	}

}
