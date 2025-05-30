package org.example;

public class Topping {

    private String name; //Name of topping
    private int quantity; //Number of topping units selected
    private ToppingType type; //Topping categories

    //Constructor
    public Topping(String name, int quantity, ToppingType type) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ToppingType getType() {
        return type;
    }

    public void setType(ToppingType type) {
        this.type = type;
    }

    //Enum representing the different types of toppings
    public enum ToppingType {
        //Meats
        STEAK("MEAT"),
        HAM("MEAT"),
        SALAMI("MEAT"),
        ROAST_BEEF("MEAT"),
        CHICKEN("MEAT"),
        BACON("MEAT"),

        //Cheeses
        AMERICAN("CHEESE"),
        PROVOLONE("CHEESE"),
        CHEDDAR("CHEESE"),
        SWISS("CHEESE"),

        //Regular Toppings
        LETTUCE("REGULAR"),
        PEPPERS("REGULAR"),
        ONIONS("REGULAR"),
        TOMATOES("REGULAR"),
        JALAPENOS("REGULAR"),
        CUCUMBERS("REGULAR"),
        PICKLES("REGULAR"),
        GUACAMOLE("REGULAR"),
        MUSHROOMS("REGULAR"),

        //Sauces
        MAYO("SAUCE"),
        MUSTARD("SAUCE"),
        KETCHUP("SAUCE"),
        RANCH("SAUCE"),
        THOUSAND_ISLANDS("SAUCE"),
        VINAIGRETTE("SAUCE");


        private final String category;

        ToppingType(String category) {
            this.category = category;
        }

        public String getCategory() {
            return category;
        }
    }
}

