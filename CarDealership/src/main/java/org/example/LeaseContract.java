package org.example;

public class LeaseContract extends Contract {
    double expectedEndingValue;
    double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail,
                         Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * 0.5;
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        int months = 36;
        double annualInterestRate = 0.04;
        double monthlyInterestRate = annualInterestRate / 12;

        double monthlyPayment = totalPrice * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate,
                months)) / (Math.pow(1 + monthlyInterestRate, months) - 1);

        return monthlyPayment;

    }
}