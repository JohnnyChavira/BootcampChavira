package org.example;

import java.util.Scanner;

import static org.example.Book.*;

public class Main {
    public static void main(String[] args) {

        Book[] inventory = new Book[20];
        Book book1 = new Book(101, "100201", "The Great Gatsby", true, "Trent");
        inventory[0] = book1;
        Book book2 = new Book(102, "100202", "1984", false);
        inventory[1] = book2;
        Book book3 = new Book(103, "100203", "To Kill a Mockingbird", false);
        inventory[2] = book3;
        Book book4 = new Book(104, "100204", "The Hobbit", true, "Tyrese");
        inventory[3] = book4;
        Book book5 = new Book(105, "100205", "Pride and Prejudice", true, "Citlali");
        inventory[4] = book5;

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose an option");
            System.out.println("1) Available books");
            System.out.println("2) Check a book in");
            System.out.println("3) Books currently checked out");
            System.out.println("4) Exit");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice){
                case 1 :
                    booksIn(inventory);
                    break;
                case 2:
                    bookCheckIn(inventory, scanner);
                    break;
                case 3:
                    booksOut(inventory);
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
        }


    }