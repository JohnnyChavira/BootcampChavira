package org.example;

public class SalesContract extends Contract {
    double salesTaxAmount;
    double recordingFee;
    double processingFee;
    boolean finance;

    public SalesContract(String date, String customerName, String customerEmail,
                         Vehicle vehicle, boolean finance) {

        super(date, customerName, customerEmail, vehicle);

        //finance
        this.finance = finance;

        //Calculate fees
        double price = vehicle.getPrice(); //price once and use it

        this.salesTaxAmount = price * 0.05;
        this.recordingFee = 100.00;

        if (price < 10000) {
            this.processingFee = 295.00;
        } else {
            this.processingFee = 495.00;
        }
    }

    @Override
    public double getTotalPrice() {
        double basePrice = getVehicle().getPrice();
        return basePrice + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0.00;
        }

        double totalPrice = getTotalPrice();

        int months;
        double annualInterestRate;

        if (totalPrice < 10000) {
            months = 24;
            annualInterestRate = 0.0525;
        } else {
            months = 48;
            annualInterestRate = 0.0425;
        }

        double monthlyInterestRate = annualInterestRate / 12;

        double monthlyPayment = totalPrice * (monthlyInterestRate * Math.pow(1 +
                monthlyInterestRate, months)) / (Math.pow(1 + monthlyInterestRate, months) - 1);

        return monthlyPayment;
    }
}
