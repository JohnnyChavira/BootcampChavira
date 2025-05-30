package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    //Enums for bread options
    public enum BreadType {
        WHITE, WHEAT, WRAP, RYE
    }

    public enum BreadSize {
        FOUR_INCH, EIGHT_INCH, TWELVE_INCH
    }

    //Fields
    private BreadType type;
    private BreadSize size;
    private boolean isToasted;
    private List<Topping> toppingList;

    //Constructor
    public Sandwich(BreadType type, BreadSize size, boolean isToasted) {
        this.type = type;
        this.size = size;
        this.isToasted = isToasted;
        this.toppingList = new ArrayList<>();

    }

    //Topping & Sauce methods


    public void addTopping(Topping topping) {
        toppingList.add(topping);
    }


    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }


    //Calculates price based on size & toppings
    public double getPrice() {
        double basePrice = 0.0;

        switch (size) {
            case FOUR_INCH:
                basePrice = 5.50;
                break;
            case EIGHT_INCH:
                basePrice = 7.00;
                break;
            case TWELVE_INCH:
                basePrice = 8.50;
                break;
        }

        //Cost of each topping
        for (Topping topping : toppingList) {
            double toppingPrice = 0.0;
            int qty = topping.getQuantity();
            String category = topping.getType().getCategory();

            switch (category) {
                case "MEAT":
                    toppingPrice = switch (size) {
                        case FOUR_INCH -> 1.00;
                        case EIGHT_INCH -> 2.00;
                        case TWELVE_INCH -> 3.00;
                    };
                    break;
                case "CHEESE":
                    toppingPrice = switch (size) {
                        case FOUR_INCH -> 0.75;
                        case EIGHT_INCH -> 1.50;
                        case TWELVE_INCH -> 2.25;
                    };
                    break;
                case "REGULAR":
                case "SAUCE":
                    toppingPrice = 0.0;
                    break;
            }

            basePrice += toppingPrice * qty;

        }

        return basePrice;
    }

    //Display

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //Bread type & toast status
        sb.append(size).append(" ").append(type);
        sb.append(isToasted ? " (Toasted)\n" : "(Not Toasted)\n");

        sb.append("Toppings:\n");
        for (Topping topping : toppingList) {
            if (!topping.getType().getCategory().equals("SAUCE")) {
                sb.append("- ")
                        .append(topping.getName())
                        .append(" x")
                        .append(topping.getQuantity())
                        .append("\n");
            }
        }

        sb.append("Sauces:\n");
        for (Topping topping : toppingList) {
            if (topping.getType().getCategory().equals("SAUCE")) {
                sb.append("- ")
                        .append(topping.getName())
                        .append(" x")
                        .append(topping.getQuantity())
                        .append("\n");
            }
        }

        return sb.toString();
    }
}
//Toppings & sauces are managed internally ENCAPSULATION