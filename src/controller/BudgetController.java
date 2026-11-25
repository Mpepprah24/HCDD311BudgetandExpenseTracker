package controller;

import model.Budget;
import model.Expense;
import model.User;
import model.Category;

public class BudgetController {

    private User user;
    private Budget budget;

    public BudgetController(User user, Budget budget) {
        this.user = user;
        this.budget = budget;
    }

    public void addExpense(String name, double amount, Category category) {
        Expense expense = new Expense(name, amount, category);
        budget.addExpense(expense);
    }

    public double getTotalExpenses() {
        return budget.calculateTotalExpenses();
    }

    public double getRemainingBudget() {
        return budget.getLimit() - getTotalExpenses();
    }

    public User getUser() {
        return user;
    }

    public Budget getBudget() {
        return budget;
    }
}
