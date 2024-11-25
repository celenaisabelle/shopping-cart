import java.util.ArrayList;

public class ShoppingCart {
    private String customerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> cartItems;

    // Default constructor
    public ShoppingCart() {
        this.customerName = "none";
        this.currentDate = "January 1, 2016";
        this.cartItems = new ArrayList<>();
    }

    // Parameterized constructor
    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
        this.cartItems = new ArrayList<>();
    }

    // Accessors
    public String getCustomerName() { return customerName; }
    public String getDate() { return currentDate; }

    // Add item
    public void addItem(ItemToPurchase item) {
        cartItems.add(item);
    }

    // Remove item
    public void removeItem(String itemName) {
        boolean found = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getName().equals(itemName)) {
                cartItems.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in cart. Nothing removed.");
        }
    }

    // Modify item
    public void modifyItem(ItemToPurchase newItem) {
        boolean found = false;
        for (ItemToPurchase item : cartItems) {
            if (item.getName().equals(newItem.getName())) {
                if (!newItem.getDescription().equals("none")) {
                    item.setDescription(newItem.getDescription());
                }
                if (newItem.getPrice() != 0) {
                    item.setPrice(newItem.getPrice());
                }
                if (newItem.getQuantity() != 0) {
                    item.setQuantity(newItem.getQuantity());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in cart. Nothing modified.");
        }
    }

    // Get number of items
    public int getNumItemsInCart() {
        int totalQuantity = 0;
        for (ItemToPurchase item : cartItems) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }

    // Get cost of cart
    public int getCostOfCart() {
        int totalCost = 0;
        for (ItemToPurchase item : cartItems) {
            totalCost += item.getPrice() * item.getQuantity();
        }
        return totalCost;
    }

    // Print total
    public void printTotal() {
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("Number of Items: " + getNumItemsInCart());
        if (cartItems.isEmpty()) {
            System.out.println("SHOPPING CART IS EMPTY");
        } else {
            for (ItemToPurchase item : cartItems) {
                item.printItemCost();
            }
            System.out.println("\nTotal: $" + getCostOfCart());
        }
    }

    // Print descriptions
    public void printDescriptions() {
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("\nItem Descriptions");
        if (cartItems.isEmpty()) {
            System.out.println("SHOPPING CART IS EMPTY");
        } else {
            for (ItemToPurchase item : cartItems) {
                item.printItemDescription();
            }
        }
    }
}
