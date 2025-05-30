package org.example;

public class Chips {

    //Enum listing for available chip flavors
    public enum ChipsType {
        DORITOS, RUFFLES, LAYS, CHEETOS, FRITOS, PRINGLES, TAKIS
    }

    private ChipsType type;
    private int quantity; //Number of bags
    private double price;

    public Chips(ChipsType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
        this.price = 1.50;
    }

    public ChipsType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return quantity + "x " + type + " chips ($" + String.format("%.2f", getTotalPrice()) + ")";
    }
}
