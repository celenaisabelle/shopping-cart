import java.util.Scanner;

public class ShoppingCartManager {
    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
    }

    public static void executeMenu(char option, ShoppingCart cart, Scanner scnr) {
        switch (option) {
            case 'a': {
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter the item name:");
                String name = scnr.nextLine();
                System.out.println("Enter the item description:");
                String description = scnr.nextLine();
                System.out.println("Enter the item price:");
                int price = scnr.nextInt();
                System.out.println("Enter the item quantity:");
                System.out.println();
                int quantity = scnr.nextInt();
                scnr.nextLine(); // Consume newline
                cart.addItem(new ItemToPurchase(name, description, price, quantity));
                break;
            }
            case 'd': {
                System.out.println("REMOVE ITEM FROM CART");
                System.out.println("Enter name of item to remove:");
                String name = scnr.nextLine();
                cart.removeItem(name);
                break;
            }
            case 'c': {
                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name:");
                String name = scnr.nextLine();
                System.out.print("Enter the new quantity:");
                int quantity = scnr.nextInt();
                scnr.nextLine(); // Consume newline
                cart.modifyItem(new ItemToPurchase(name, "none", 0, quantity));
                break;
            }
            case 'i': {
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                cart.printDescriptions();
                System.out.println();
                break;
            }
            case 'o': {
                System.out.println("OUTPUT SHOPPING CART");
                cart.printTotal();
                System.out.println();
                break;
            }
            case 'q':
                break;
            default:
                System.out.println("Choose an option:");
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Input customer info
        System.out.println("Enter customer's name:");
        String customerName = scnr.nextLine();
        System.out.println("Enter today's date:");
        String date = scnr.nextLine();
        System.out.println("\nCustomer name: " + customerName);
        System.out.println("Today's date: " + date);

        System.out.println();

        ShoppingCart cart = new ShoppingCart(customerName, date);

        char choice;
        boolean validOption;

        // Print menu once at the start
        printMenu();
        System.out.println();
        System.out.println("Choose an option:");

        do {
            choice = scnr.nextLine().charAt(0);

            // Check if the option is valid
            validOption = "adicioq".indexOf(choice) != -1;

            if (validOption) {
                executeMenu(choice, cart, scnr);

                // Only reprint the menu for valid options, except quit
                if (choice != 'q') {
                    printMenu();
                    System.out.println("\nChoose an option:");
                }
            } else {
                // When invalid, prompt for input again without printing the menu
                System.out.println("Choose an option:");
            }

        } while (choice != 'q');

        scnr.close();
    }
}