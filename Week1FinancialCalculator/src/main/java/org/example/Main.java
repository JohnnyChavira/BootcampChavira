package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your mortgage calculator" );
        System.out.println("Input the information for the following");

        System.out.println("Principal amount");
        double p = scanner.nextDouble();

        System.out.println("Interest rate");
        double a = scanner.nextDouble();
        double r = (a/12) / 100;

        System.out.println("Loan length in years");
        double loanTerm = scanner.nextDouble();
        double n = (loanTerm * 12);

        //M = P[r(1+r)^n] / [(1+r)^n-1]
        double j=1+r;
        double l=Math.pow(j,n);
        double left=(l * r) * p;
        double right = (l - 1);
        double monthlyPayments = left/right;
        double interest = (monthlyPayments * n) - p;
        System.out.printf("Monthly bill is $%.2f, total interest due is $%.2f"
                ,monthlyPayments, interest);

        scanner.close();
    }
}