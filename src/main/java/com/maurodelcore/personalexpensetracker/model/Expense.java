// Expense.java
package com.maurodelcore.personalexpensetracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a financial transaction, either income or expenditure.
 *
 * <p>Each expense holds the transaction type, date, amount, category,
 * payment account, and an optional note. Null notes are excluded
 * from JSON output via {@code @JsonInclude}.</p>
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    /** {@code true} for income, {@code false} for expenditure. */
    private boolean type;

    /** Date of the transaction in {@code yyyy-MM-dd} format. */
    private String date;

    /** Transaction amount in the local currency. */
    private double amount;

    /** Category of the transaction (e.g. groceries, salary, dining). */
    private String category;

    /** Payment source (e.g. bank, cash, credit card). */
    private String account;

    /** Optional description of the transaction. Omitted from JSON when null. */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String note;
}