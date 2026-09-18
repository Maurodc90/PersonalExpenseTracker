package com.maurodelcore.personalexpensetracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {


    private boolean type; //Expense type — income or expenditure (true = income, false = expenditure)
    private String date; //Date — when the expense or income occurred
    private double amount; //Amount — the amount spent or received
    private String category; //Category — e.g. groceries, utilities, salary
    private String account; //Account — source of funds (cash, bank, credit card)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String note; //Note — optional description

}
