package view;

import controller.BudgetController;
import model.Category;

import java.util.Scanner;

public class BudgetView {

    private BudgetController controller;
    private Scanner scanner;

    public BudgetView(BudgetController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    showSummary();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Budget Tracker ===");
        System.out.println("1. Add Expense");
        System.out.println("2. View Summary");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private void addExpense() {
        System.out.print("Expense name: ");
        String name = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Category (FOOD, RENT, FUN, OTHER): ");
        Category category = Category.valueOf(scanner.nextLine().toUpperCase());

        controller.addExpense(name, amount, category);
        System.out.println("Expense added.");
    }

    private void showSummary() {
        System.out.println("\nTotal spent: $" + controller.getTotalExpenses());
        System.out.println("Remaining budget: $" + controller.getRemainingBudget());
    }
}
