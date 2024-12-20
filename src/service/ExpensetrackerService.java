package src.service;

import src.entity.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpensetrackerService {
    static long count = 0;
    static Map<Long, Expense> expenseMap = new HashMap<>();

    public void addExpense(String description, double amount) {
        Expense expense = new Expense(++count, description, amount);
        expenseMap.put(count, expense);
        System.out.println("Expense added successfully : " + expense);
    }

    public void updateExpense(Long id, String description, double amount) {
        Expense expense = expenseMap.get(id);

        if (expense != null) {
            if (description != null) expense.setDescription(description);
            if (amount != 0) expense.setAmount(amount);
            System.out.println("Expense updated successfully : " + expense);
        } else {
            System.out.println("No expense exist");
        }
    }

    public void updateExpense(Long id, double amount) {
        updateExpense(id, null, amount);
    }

    public void updateExpense(Long id, String description) {
        updateExpense(id, description, 0);
    }

    public void deleteExpense(Long id) {
        Expense expense = expenseMap.get(id);
        if (expense != null) {
            expenseMap.remove(id, expense);
            System.out.println("Successfully deleted");
        } else {
            System.out.println("No expense exist");
        }
    }

    public void displayExpense() {
        if (!expenseMap.isEmpty()) {
            for (Map.Entry<Long, Expense> expenseEntry : expenseMap.entrySet()) {
                System.out.println(expenseEntry.getValue().toString());
            }
        } else {
            System.out.println("No expense exist");
        }
    }
}
