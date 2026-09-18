package com.maurodelcore.personalexpensetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalExpenseController {
    // The application will use GET endpoints to fetch expenses based on various filters
    // like date, category, and available categories.

    @GetMapping("")
    public String getExpenses() {
        return "Hello Expense";
    }

}
