import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        int choice;

        do {
            System.out.println("\n==== Inventory Management System ====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Delete Product");
            System.out.println("4. Save Products to File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    Product product = new Product(name, price, quantity);
                    manager.addProduct(product);
                    break;
                case 2:
                    manager.viewProducts();
                    break;
                case 3:
                    manager.viewProducts();
                    System.out.print("Enter product number to delete: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();
                    manager.deleteProduct(index);
                    break;
                case 4:
                    manager.saveToFile();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
