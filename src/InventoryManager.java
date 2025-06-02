import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class InventoryManager {
    private ArrayList<Product> products;

    public InventoryManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully!");
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products to display.");
            return;
        }
        System.out.println("\n--- Product List ---");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    public void deleteProduct(int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Invalid product number.");
        }
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("inventory.txt")) {
            for (Product product : products) {
                writer.write(product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "\n");
            }
            System.out.println("Products saved to inventory.txt successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file.");
            e.printStackTrace();
        }
    }
}
