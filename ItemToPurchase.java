public class ItemToPurchase {
    private String itemName;
    private String itemDescription;
    private int itemPrice;
    private int itemQuantity;

    // Default constructor
    public ItemToPurchase() {
        itemName = "none";
        itemDescription = "none";
        itemPrice = 0;
        itemQuantity = 0;
    }

    // Parameterized constructor
    public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    // Mutators
    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    // Accessors
    public String getName() {
        return itemName;
    }

    public String getDescription() {
        return itemDescription;
    }

    public int getPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    // Print item cost
    public void printItemCost() {
        System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemPrice * itemQuantity));
    }

    // Print item description
    public void printItemDescription() {
        System.out.println(itemName + ": " + itemDescription);
    }
}