package org.example;

public class Drink {

    //Enums for drinks
    public enum DrinkSize {
        SMALL, MEDIUM, LARGE
    }

    public enum DrinkFlavor {
        COKE, SPRITE, PEPSI, LEMONADE, DR_PEPPER, MOUNTAIN_DEW, FANTA;

        @Override
        public String toString() {
            String lower = name().toLowerCase().replace("_", "");
            return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
        }
        }

    private DrinkSize size;
    private DrinkFlavor flavor;
    private double price;


    public Drink(DrinkSize size, DrinkFlavor flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice(size);
    }

    private double calculatePrice(DrinkSize size) {
        return switch (size) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    public double getPrice() {
        return price;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return size + " " + flavor + " drink ($" + String.format("%.2f", getPrice()) + ")";
    }
}
