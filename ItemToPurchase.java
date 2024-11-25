import java.util.Scanner;

public class ItemToPurchase {
    private String itemName;
    private String itemDescription;
    private int itemPrice;
    private int itemQuantity;

    // Default constructor
    public ItemToPurchase() {
        this.itemName = "none";
        this.itemDescription = "none";
        this.itemPrice = 0;
        this.itemQuantity = 0;
    }

    // Parameterized constructor
    public ItemToPurchase(String name, String description, int price, int quantity) {
        this.itemName = name;
        this.itemDescription = description;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }

    // Mutators and accessors
    public void setName(String name) { this.itemName = name; }
    public String getName() { return itemName; }
    public void setDescription(String description) { this.itemDescription = description; }
    public String getDescription() { return itemDescription; }
    public void setPrice(int price) { this.itemPrice = price; }
    public int getPrice() { return itemPrice; }
    public void setQuantity(int quantity) { this.itemQuantity = quantity; }
    public int getQuantity() { return itemQuantity; }

    // Methods
    public void printItemCost() {
        System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemPrice * itemQuantity));
    }

    public void printItemDescription() {
        System.out.println(itemName + ": " + itemDescription);
    }
}
