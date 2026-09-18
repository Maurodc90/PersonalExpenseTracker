package com.maurodelcore.personalexpensetracker.service;

import com.maurodelcore.personalexpensetracker.controller.PersonalExpenseController;
import com.maurodelcore.personalexpensetracker.model.Expense;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;

@Service
public class PersonalExpenseService {

//    PersonalExpenseController personalExpenseController;

    // // Boolean type, String Date, double amount, String category, String account, String note
    InputStream inputStream = getClass().getResourceAsStream("/expenses.json");
    ObjectMapper objectMapper = new ObjectMapper();

    PersonalExpenseController personalExpenseController = objectMapper.readValue(inputStream, PersonalExpenseController.class);






}
