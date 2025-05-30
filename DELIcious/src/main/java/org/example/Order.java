package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    //Fields that hold all for sandwiches, drinks, and chips in order
    private List<Sandwich> sandwichList;
    private List<Drink> drinkList;
    private List<Chips> chipsList;
    private LocalDateTime creationDateTime; //Timestamp of order creation

    //Constructor
    public Order() {
        sandwichList = new ArrayList<>();
        drinkList = new ArrayList<>();
        chipsList = new ArrayList<>();
        creationDateTime = LocalDateTime.now(); //Records time of order started
    }

    //Getters & Setters
    public List<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichList(List<Sandwich> sandwichList) {
        this.sandwichList = sandwichList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }

    public void setChipsList(List<Chips> chipsList) {
        this.chipsList = chipsList;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    //Adds Items
    public void addSandwich(Sandwich sandwich) {
        this.sandwichList.add(sandwich);
    }

    public void addDrink(Drink drink) {
        this.drinkList.add(drink);
    }

    public void addChips(Chips chips) {
        this.chipsList.add(chips);
    }

    //Price Calculations for sandwich, chips, drink
    public double getTotalPrice() {
        double total = 0.0;

        for (int i = 0; i < sandwichList.size(); i++) {
            Sandwich sandwich = sandwichList.get(i);
            double sandwichPrice = sandwich.getPrice();
            total += sandwichPrice;
        }

        for (int i = 0; i < chipsList.size(); i++) {
            Chips chips = chipsList.get(i);
            double chipsPrice = chips.getTotalPrice();
            total += chipsPrice;
        }

        for (int i = 0; i < drinkList.size(); i++) {
            Drink drink = drinkList.get(i);
            double drinkPrice = drink.getPrice();
            total += drinkPrice;
        }

        return total;
    }

    //String representations for receipt & checkout
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("======= ORDER SUMMARY =======\n");
        sb.append("Order Time: ").append(creationDateTime).append("\n\n");

        //Lists sandwiches
        for (int i = 0; i < sandwichList.size(); i++) {
            Sandwich sandwich = sandwichList.get(i);
            sb.append("Sandwich #").append(i + 1).append(":\n");
            sb.append(sandwich.toString()).append("\n\n");
        }

        //Lists drinks
        sb.append("Drinks:\n");
        for (int i = 0; i < drinkList.size(); i++) {
            Drink drink = drinkList.get(i);
            sb.append("Drink #").append(i + 1).append(": ").append(drink.toString()).append("\n");
        }

        //List chips
        sb.append("Chips\n");
        for (int i = 0; i < chipsList.size(); i++) {
            Chips chips = chipsList.get(i);
            sb.append("Chips #").append(i + 1).append(": ").append(chips.toString()).append("\n");
        }

        //Shows total price
        sb.append("\nTotal Price: $").append(String.format("%.2f", getTotalPrice())).append("\n");
        return sb.toString();
    }

}