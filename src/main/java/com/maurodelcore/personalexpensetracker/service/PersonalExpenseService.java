// PersonalExpenseService.java
package com.maurodelcore.personalexpensetracker.service;

import com.maurodelcore.personalexpensetracker.model.Expense;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service layer for loading and querying expense data.
 *
 * <p>Reads expenses from {@code expenses.json} in the classpath at startup
 * and provides filtering methods by date, category, and account.</p>
 *
 */
@Service
public class PersonalExpenseService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Expense> expenses = new ArrayList<>();

    /**
     * Loads expense data from {@code /expenses.json} on the classpath.
     *
     * <p>Runs automatically after Spring creates this bean.
     * Throws {@link RuntimeException} if the file cannot be read,
     * causing the application to fail at startup rather than run
     * with missing data.</p>
     */
    @PostConstruct
    public void init() {
        try (InputStream inputStream = getClass().getResourceAsStream("/expenses.json")) {
            expenses = objectMapper.readValue(inputStream, new TypeReference<List<Expense>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns all loaded expenses.
     *
     * @return list of all expenses
     */
    public List<Expense> listExpenses() {
        return expenses;
    }

    /**
     * Filters expenses by the given date.
     *
     * @param date the date to filter by, in {@code yyyy-MM-dd} format
     * @return list of expenses matching the date, or an empty list if none match
     */
    public List<Expense> expensesByDate(String date) {
        List<Expense> expensesByDate = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getDate().equals(date)) {
                expensesByDate.add(expense);
            }
        }
        return expensesByDate;
    }

    /**
     * Filters expenses by the given category.
     *
     * @param category the category to filter by (e.g. "groceries", "salary")
     * @return list of expenses matching the category, or an empty list if none match
     */
    public List<Expense> expensesByCategory(String category) {
        List<Expense> expensesByCategory = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equals(category)) {
                expensesByCategory.add(expense);
            }
        }
        return expensesByCategory;
    }

    /**
     * Filters expenses by the given payment account.
     *
     * @param account the account to filter by (e.g. "bank", "cash", "credit card")
     * @return list of expenses matching the account, or an empty list if none match
     */
    public List<Expense> expensesByAccount(String account) {
        List<Expense> expensesByAccount = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getAccount().equals(account)) {
                expensesByAccount.add(expense);
            }
        }
        return expensesByAccount;
    }

    /**
     * Returns all distinct expense categories.
     *
     * @return set of category names
     */
    public Set<String> listCategories() {
        Set<String> categories = new HashSet<>();
        for (Expense expense : expenses) {
            categories.add(expense.getCategory());
        }
        return categories;
    }

    /**
     * Returns all distinct payment accounts.
     *
     * @return set of account names
     */
    public Set<String> listAccounts() {
        Set<String> accounts = new HashSet<>();
        for (Expense expense : expenses) {
            accounts.add(expense.getAccount());
        }
        return accounts;
    }
}