package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    //Main starting point of the application
    public void start() {
        while (true) {
            System.out.println("Welcome to Johnny's sandwiches!");
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> handleNewOrder();
                case 0 -> {
                    System.out.println("Thanks for visiting, Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }


       private void handleNewOrder() {
           Order order = new Order();

           while (true) {
               System.out.println("\n===== ORDER MENU =====");
               System.out.println("1) Add Sandwich");
               System.out.println("2) Add Drink");
               System.out.println("3) Add Chips");
               System.out.println("4) Checkout");
               System.out.println("0) Cancel Order");
               System.out.print("Enter your choice: ");

               int choice = scanner.nextInt();
               scanner.nextLine(); // Clear buffer

               switch (choice) {
                   case 1 -> buildSandwich(order);
                   case 2 -> addDrink(order);
                   case 3 -> addChips(order);
                   case 4 -> {
                       checkout(order);
                       return;
                   }
                   case 0 -> {
                       System.out.println("Order cancelled.");
                       return;
                   }
                   default -> System.out.println("Invalid choice.");
               }
           }
       }

        private void buildSandwich (Order order) {
            System.out.println("Please select your type of bread: ");
            Sandwich.BreadType[] breadTypes = Sandwich.BreadType.values();
            for (int i = 0; i < breadTypes.length; i++) {
                System.out.println((i + 1) + ". " + breadTypes[i]);
            }

            int breadChoice = scanner.nextInt();
            scanner.nextLine();
            if (breadChoice < 1 || breadChoice > breadTypes.length) {
                System.out.println("Invalid choice.");
                return;
            }
            Sandwich.BreadType selectedBread = breadTypes[breadChoice - 1];

            System.out.println("Select bread size:");
            Sandwich.BreadSize[] sizes = Sandwich.BreadSize.values();
            for (int i = 0; i < sizes.length; i++) {
                System.out.println((i + 1) + ". " + sizes[i]);
            }

            int sizeChoice = scanner.nextInt();
            scanner.nextLine();
            if (sizeChoice < 1 || sizeChoice > sizes.length) {
                System.out.println("Invalid choice.");
                return;
            }
            Sandwich.BreadSize selectedSize = sizes[sizeChoice - 1];

            System.out.print("Would you like your sandwich toasted? (yes/no): ");
            boolean isToasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

            Sandwich sandwich = new Sandwich(selectedBread, selectedSize, isToasted);

            // Add toppings
            List<Topping> selectedToppings = new ArrayList<>();
            Topping.ToppingType[] allTypes = Topping.ToppingType.values();
            List<Topping.ToppingType> nonSauceToppings = new ArrayList<>();
            for (Topping.ToppingType type : allTypes) {
                if (!type.getCategory().equals("SAUCE")) {
                    nonSauceToppings.add(type);
                }
            }

            System.out.println("Available Toppings:");
            for (int i = 0; i < nonSauceToppings.size(); i++) {
                System.out.println((i + 1) + ". " + nonSauceToppings.get(i));
            }

            while (true) {
                System.out.print("Enter topping number to add (0 to finish): ");
                int toppingChoice = scanner.nextInt();
                scanner.nextLine();

                if (toppingChoice == 0) break;

                if (toppingChoice >= 1 && toppingChoice <= nonSauceToppings.size()) {
                    Topping.ToppingType selectedTopping = nonSauceToppings.get(toppingChoice - 1);

                    System.out.print("Enter quantity for " + selectedTopping + ": ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Topping topping = new Topping(selectedTopping.name(),quantity, selectedTopping);
                    selectedToppings.add(topping);
                } else {
                    System.out.println("Invalid topping selection.");
                }
            }

            System.out.print("Would you like to add sauces? (yes/no): ");
            String addSauce = scanner.nextLine().trim().toLowerCase();

            if (addSauce.equals("yes")) {
                System.out.println("Available Sauces:");
                List<Topping.ToppingType> sauces = new ArrayList<>();


                for (Topping.ToppingType type : allTypes) {
                    if (type.getCategory().equals("SAUCE")) {
                        sauces.add(type);
                    }
                }

                for (int i = 0; i < sauces.size(); i++) {
                    System.out.println((i + 1) + ". " + sauces.get(i));
                }

                while (true) {
                    System.out.print("Enter sauce number to add (0 to finish): ");
                    int sauceChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (sauceChoice == 0) break;

                    if (sauceChoice >= 1 && sauceChoice <= sauces.size()) {
                        Topping.ToppingType selectedSauce = sauces.get(sauceChoice - 1);

                        System.out.print("Enter quantity for " + selectedSauce + ": ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        Topping sauceTopping = new Topping(selectedSauce.name(), quantity, selectedSauce);
                        selectedToppings.add(sauceTopping);
                    } else {
                        System.out.println("Invalid sauce choice.");
                    }
                }
            }

            sandwich.setToppingList(selectedToppings);
            order.addSandwich(sandwich);
            System.out.println("Sandwich added to order.\n");
        }
        private void addChips (Order order) {
            Chips.ChipsType[] chipsTypes = Chips.ChipsType.values();

            System.out.println("Available Chips:");
            for (int i = 0; i < chipsTypes.length; i++) {
                System.out.println((i + 1) + ". " + chipsTypes[i]);
            }

            while (true) {
                System.out.println("Select chip by number (or 0 to finish): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) break;

                if (choice >= 1 && choice <= chipsTypes.length) {
                    Chips.ChipsType selectedChip = chipsTypes[choice - 1];

                    System.out.println("Enter quantity for " + selectedChip + ": ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Chips chips = new Chips(selectedChip, quantity);
                    order.addChips(chips);
                    System.out.println(quantity + "x " + selectedChip + " chips added to order.");
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }


        private void addDrink (Order order) {
            Drink.DrinkSize[] sizes = Drink.DrinkSize.values();
            Drink.DrinkFlavor[] flavors = Drink.DrinkFlavor.values();

            System.out.println("Available Drink Sizes:");
            for (int i = 0; i < sizes.length; i++) {
                System.out.println((i + 1) + ". " + sizes[i]);
            }

            System.out.println("Available Flavors:");
            for (int i = 0; i < flavors.length; i++) {
                System.out.println((i + 1) + ". " + flavors[i]);
            }

            System.out.println();

            while (true) {
            System.out.println("Select drink size by number (or 0 to finish): ");
            int sizeChoice = scanner.nextInt();
            scanner.nextLine();

                if (sizeChoice == 0) break;

                if (sizeChoice >= 1 && sizeChoice <= sizes.length) {
                    Drink.DrinkSize selectedSize = sizes[sizeChoice - 1];

                    System.out.print("Select drink flavor by number: ");
                    int flavorChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    if (flavorChoice >= 1 && flavorChoice <= flavors.length) {
                        Drink.DrinkFlavor selectedFlavor = flavors[flavorChoice - 1];

                        Drink drink = new Drink(selectedSize, selectedFlavor);
                        order.addDrink(drink);

                        System.out.println("Added: " + drink.toString());
                    } else {
                        System.out.println("Invalid flavor choice. Try again.");
                    }
                } else {
                    System.out.println("Invalid size choice. Try again.");
                }
            }

            System.out.println("Done adding drinks.\n");
        }

        private void checkout (Order order) {

            System.out.println("\n==== CHECKOUT ====");
            System.out.println(order);

            System.out.print("Would you like to confirm this order? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if (confirm.equals("yes")) {
                SandwichOrderFileManager.writeOrderToFile(order);
                System.out.println("Thank you! Your order has been placed.");
            } else {
                System.out.println("Order canceled.\n");
            }

            System.out.println("Returning to home screen...\n");
        }
    }