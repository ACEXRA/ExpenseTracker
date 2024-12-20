package src;

import src.service.ExpensetrackerService;

import java.util.Scanner;

public class ExpenseTracker {
    private final ExpensetrackerService expensetrackerService;

    //Constructor dependency injection of service
    ExpenseTracker(ExpensetrackerService expensetrackerService) {
        this.expensetrackerService = expensetrackerService;
    }

    public static void main(String[] args) {
        // Inject the dependency
        ExpensetrackerService service = new ExpensetrackerService();

        // Create an instance of ExpenseApplication with the dependency
        ExpenseTracker app = new ExpenseTracker(service);

        app.runExpenseTracker();
    }

    public void runExpenseTracker() {
        System.out.println("Expense Tracker");
        System.out.println("Enter the expense: description-amount");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String input = scanner.nextLine();
            flag = expenseApplication(input);
        }
    }

    public boolean expenseApplication(String input) {
        String[] arr = input.split("-");

        if (arr.length < 1) {
            System.out.println("Enter a valid input");
            return true;
        }

        switch (arr[0]) {
            case "add":
                if (arr.length > 2) {
                    expensetrackerService.addExpense(arr[1], Double.parseDouble(arr[2]));
                } else {
                    System.out.println("Enter a valid input");
                }
                break;
            //update-amount-1-20
            case "update":
                if (arr.length > 3) {
                    if (arr[1].equals("amount")) {
                        expensetrackerService.updateExpense(Long.valueOf(arr[2]), Double.parseDouble(arr[3]));
                    } else if (arr[1].equals("description")) {
                        expensetrackerService.updateExpense(Long.valueOf(arr[2]), arr[3]);
                    } else {
                        expensetrackerService.updateExpense(Long.valueOf(arr[1]), arr[2], Double.parseDouble(arr[3]));
                    }
                }
                break;
            case "delete":
                if (arr.length > 1) {
                    expensetrackerService.deleteExpense(Long.valueOf(arr[1]));
                }
                break;
            case "display":
                expensetrackerService.displayExpense();
                break;
            case "end":
                return false;
            default:
                System.out.println("Enter a valid input");
                break;
        }
        return true;
    }
}
