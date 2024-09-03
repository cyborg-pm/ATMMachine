package as;
import java.util.Scanner;

public class ATMMachine {

    private static double balance = 1000.00; // Initial balance in INR

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Welcome to the ATM Machine ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f\n", balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ₹");
        double deposit = scanner.nextDouble();
        if (deposit > 0) {
            balance += deposit;
            System.out.printf("You have successfully deposited ₹%.2f. Your new balance is ₹%.2f\n", deposit, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ₹");
        double withdraw = scanner.nextDouble();
        if (withdraw > 0 && withdraw <= balance) {
            balance -= withdraw;
            System.out.printf("You have successfully withdrawn ₹%.2f. Your new balance is ₹%.2f\n", withdraw, balance);
        } else if (withdraw > balance) {
            System.out.println("Insufficient balance. Please enter a smaller amount.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}
