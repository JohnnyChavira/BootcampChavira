package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello and welcome");
            System.out.println("Select an option\n");
            System.out.println("1.)Add Deposit");
            System.out.println("2.)Make Payment");
            System.out.println("3.)View Ledger");
            System.out.println("4.) Exit");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    viewLedger();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");


            }
        }

    }

    public static void addDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input purpose of your deposit: ");
        String description = scanner.nextLine();

        System.out.println("Input name of vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Error: Deposit must be positive");
            return;
        }

        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        Transaction transaction = new Transaction(date, time, description, vendor, amount);

        FileManager.appendTransaction(transaction);
        System.out.println("Deposit successfully processed");
    }

    public static void makePayment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input purpose of your payment: ");
        String description = scanner.nextLine();

        System.out.println("Input name of vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount >= 0) {
            System.out.println("Error: Payment must be negative");
            return;
        }

        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        Transaction transaction = new Transaction(date, time, description, vendor, amount);

        FileManager.appendTransaction(transaction);
        System.out.println("Payment successfully processed");
    }

    public static void viewLedger() {
        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactions = FileManager.readFile();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        } else {


            System.out.println("View Ledger: ");
            System.out.println("1.)All Transactions");
            System.out.println("2.)Deposits Only");
            System.out.println("3.)Payments Only");

            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    allTransactions(transactions);
                    break;
                case 2:
                    depositsOnly(transactions);
                    break;
                case 3:
                    paymentsOnly(transactions);
                    break;
            }

        }

    }

    public static void allTransactions(List<Transaction> transactions) {
        Collections.reverse(transactions);
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public static void depositsOnly(List<Transaction> transactions) {
        Collections.reverse(transactions);
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }

    }

    public static void paymentsOnly(List<Transaction> transactions) {
        Collections.reverse(transactions);
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }
}
