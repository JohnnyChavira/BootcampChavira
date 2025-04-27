package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> allProducts = FileLoader.readFile();
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("Welcome to the store! Choose an option:");
            System.out.println("1. View all products");
            System.out.println("2. Search by SKU");
            System.out.println("3. Search by price range");
            System.out.println("4. Search by name");
            System.out.println("5. Add to cart");
            System.out.println("6. Remove from cart");
            System.out.println("7. View cart");
            System.out.println("8. Checkout");
            System.out.println("9. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Call method to display all products
                    //* for-each loop to print/display each product
                    for (Product product : allProducts){
                        System.out.println("SKU:" + product.getSKU() + ", Name: " + product.getProductName()
                        + ", Price: $" + product.getPrice() + ", Department:" + product.getDepartment());
                    }
                    break;
                case 2:
                    // Prompt for SKU and call method to search product by SKU
                    System.out.println("Input SKU to search: ");
                    String skuSearch = scanner.nextLine().trim();
                    Product found = findBySku(allProducts, skuSearch);
                    if(found != null){
                        System.out.println("Product Found");
                        System.out.println("SKU: " + found.getSKU());
                        System.out.println("Name: " + found.getProductName());
                        System.out.println("Price: $" + found.getPrice());
                        System.out.println("Department: " + found.getDepartment());
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case 3:
                    // Prompt for min and max price and call method to filter products
                    System.out.println("Input minimum price: ");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.println("Input maximum price: ");
                    double max = Double.parseDouble(scanner.nextLine());
                    List<Product> filtered = filterByPriceRange(allProducts, min, max);
                    displayProducts(filtered);
                    break;
                case 4:
                    // Prompt for name and call method to search products by name
                    System.out.println("Input product name: ");
                    String name = scanner.nextLine();
                    List<Product> matches = searchByName(allProducts, name);
                    displayProducts(matches);
                    break;
                case 5:
                    // Prompt for SKU, find product, and add to cart
                    //Remember to use the shopping cart we made above!
                    System.out.println("Enter SKU of product to add to cart: ");
                    String skuToAdd = scanner.nextLine();
                    Product productToAdd = findBySku(allProducts, skuToAdd);
                    if(productToAdd != null){
                        cart.addProductToCart(productToAdd);
                        System.out.println("Added to cart");
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case 6:
                    // Prompt for SKU to get the product, remove from cart

                    break;
                case 7:
                    // Display cart items. Remember, use the shopping cart above!
                    break;
                case 8:
                    // Display total and thank the user
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    //This method could be re-used over and over again if you play
    //your cards right!
    public static void displayProducts(List<Product> products) {
        // TODO: Loop through products
        // Print SKU, Name, Price, and Department nicely
    }

    public static Product findBySku(List<Product> products, String sku) {
        // TODO: Loop through products
        // If sku matches, return the product
        return null; // if not found
    }

    // Returns a list of products with names that contain the search string (case-insensitive)
    public static List<Product> searchByName(List<Product> products, String name) {
        List<Product> matches = new ArrayList<>();
        // TODO: Loop through products
        // If product name contains the search string, add to matches
        return matches;
    }

    // Returns a list of products within the given price range (inclusive)
    public static List<Product> filterByPriceRange(List<Product> products, double min, double max) {
        List<Product> matches = new ArrayList<>();
        // TODO: Loop through products
        // If product price is between min and max, add to matches
        return matches;
    }
}