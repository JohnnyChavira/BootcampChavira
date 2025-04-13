package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the initial deposit?");
        double p = scanner.nextDouble();

        System.out.println("What is the interest rate?");
        double a = scanner.nextDouble();
        double r = (a/365);
        double n = 365;

        System.out.println("What is the number of years?");
        double t = scanner.nextDouble();

        //FV = P (1 + r/n) ^ (n * t)
        double j = 1 + r/n;
        double k = n * t;
        double l = Math.pow(j,k);
        double futureValue = p * l;
        double interest = futureValue - p;
        System.out.printf("Future value is $%.2f, total interest is $%.2f",
                futureValue, interest);

        scanner.close();

    }
}