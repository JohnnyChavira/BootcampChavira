package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the monthly payout amount?");
        double pmt = scanner.nextDouble();

        System.out.println("What is the expected interest rate?");
        double a = scanner.nextDouble();
        double r = (a/12) / 100;

        System.out.println("What is the number of years to pay out?");
        double numberOfYears = scanner.nextDouble();
        double n = (numberOfYears * 12);

        //PV = PMT * [(1 - (1 + r) ^ (-n) ) / r]
        double j = 1 + r;
        double k = Math.pow(j, -n);
        double l = 1 - k;
        double m = l / r;
        double presentValue = pmt * m;
        System.out.printf("Present value is $%.2f ", presentValue);

        scanner.close();
    }
}