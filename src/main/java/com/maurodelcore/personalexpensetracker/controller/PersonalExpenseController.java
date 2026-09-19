// PersonalExpenseController.java
package com.maurodelcore.personalexpensetracker.controller;

import com.maurodelcore.personalexpensetracker.model.Expense;
import com.maurodelcore.personalexpensetracker.service.PersonalExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * REST controller exposing expense data through GET endpoints.
 *
 * <p>Delegates all business logic to {@link PersonalExpenseService}.
 * Responses are serialized to JSON by Spring and Jackson.</p>
 *
 */
@RequestMapping
@RestController
public class PersonalExpenseController {

    private final PersonalExpenseService personalExpenseService;

    /**
     * Constructs the controller with the required service dependency.
     *
     * @param personalExpenseService the service handling expense data
     */
    public PersonalExpenseController(PersonalExpenseService personalExpenseService) {
        this.personalExpenseService = personalExpenseService;
    }

    /**
     * Health-check endpoint.
     *
     * @return a simple greeting string
     */
    @GetMapping("")
    public String getExpenses() {
        return "Hello Expense";
    }

    /**
     * Returns all expenses.
     *
     * @return list of all expenses as JSON
     */
    @GetMapping("/expenses")
    public List<Expense> listExpenses() {
        return personalExpenseService.listExpenses();
    }

    /**
     * Returns all distinct expense categories.
     *
     * @return set of category names as JSON
     */
    @GetMapping("/categories")
    public Set<String> listCategories() {
        return personalExpenseService.listCategories();
    }

    /**
     * Returns expenses filtered by category.
     *
     * @param category the category to filter by
     * @return list of matching expenses as JSON
     */
    @GetMapping("/categories/{category}")
    public List<Expense> filteredCategory(@PathVariable String category) {
        return personalExpenseService.expensesByCategory(category);
    }

    /**
     * Returns all distinct payment accounts.
     *
     * @return set of account names as JSON
     */
    @GetMapping("/accounts")
    public Set<String> listAccounts() {
        return personalExpenseService.listAccounts();
    }

    /**
     * Returns expenses filtered by payment account.
     *
     * @param account the account to filter by
     * @return list of matching expenses as JSON
     */
    @GetMapping("/accounts/{account}")
    public List<Expense> filteredAccount(@PathVariable String account) {
        return personalExpenseService.expensesByAccount(account);
    }

    /**
     * Returns expenses filtered by date.
     *
     * @param date the date to filter by in {@code yyyy-MM-dd} format
     * @return list of matching expenses as JSON
     */
    @GetMapping("/date/{date}")
    public List<Expense> listExpensesByDate(@PathVariable String date) {
        return personalExpenseService.expensesByDate(date);
    }
}