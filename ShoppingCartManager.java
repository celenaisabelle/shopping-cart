import java.util.Scanner;

public class ShoppingCartManager {

    public static void printMenu() {
        System.out.println("\nMENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
        System.out.print("\nChoose an option: ");
    }

    public static void executeMenu(char choice, ShoppingCart cart, Scanner scnr) {
        switch (choice) {
            case 'a':
                System.out.println("\nADD ITEM TO CART");
                System.out.print("Enter the item name: ");
                String name = scnr.nextLine();
                System.out.print("Enter the item description: ");
                String description = scnr.nextLine();
                System.out.print("Enter the item price: ");
                int price = scnr.nextInt();
                System.out.print("Enter the item quantity: ");
                int quantity = scnr.nextInt();
                scnr.nextLine(); // Consume leftover newline
                cart.addItem(new ItemToPurchase(name, description, price, quantity));
                break;

            case 'd':
                System.out.println("\nREMOVE ITEM FROM CART");
                System.out.print("Enter name of item to remove: ");
                String itemNameToRemove = scnr.nextLine();
                cart.removeItem(itemNameToRemove);
                break;

            case 'c':
                System.out.println("\nCHANGE ITEM QUANTITY");
                System.out.print("Enter the item name: ");
                String itemNameToModify = scnr.nextLine();
                System.out.print("Enter the new quantity: ");
                int newQuantity = scnr.nextInt();
                scnr.nextLine(); // Consume leftover newline
                ItemToPurchase itemToModify = new ItemToPurchase();
                itemToModify.setName(itemNameToModify);
                itemToModify.setQuantity(newQuantity);
                cart.modifyItem(itemToModify);
                break;

            case 'i':
                System.out.println("\nOUTPUT ITEMS' DESCRIPTIONS");
                cart.printDescriptions();
                break;

            case 'o':
                System.out.println("\nOUTPUT SHOPPING CART");
                cart.printTotal();
                break;

            case 'q':
                break;

            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Input customer name and date
        System.out.println("Enter customer's name:");
        String customerName = scnr.nextLine();
        System.out.println("Enter today's date:");
        String currentDate = scnr.nextLine();

        ShoppingCart cart = new ShoppingCart(customerName, currentDate);

        System.out.println("\nCustomer name: " + customerName);
        System.out.println("Today's date: " + currentDate);

        char choice = ' ';
        while (choice != 'q') {
            printMenu();
            choice = scnr.next().charAt(0);
            scnr.nextLine(); // Consume leftover newline
            executeMenu(choice, cart, scnr);
        }
    }
}