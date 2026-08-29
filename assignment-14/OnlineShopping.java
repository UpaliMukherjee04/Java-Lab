import java.util.*;

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter Product Name: ");
            String productName = sc.nextLine();

            System.out.print("Enter Product Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity to Purchase: ");
            int quantity = sc.nextInt();

            // Validate quantity
            if (quantity > 0) {
                double totalBill = price * quantity;
                System.out.println("\n Order Summary:");
                System.out.println("Product Name: " + productName);
                System.out.println("Price per unit: $" + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Total Amount Payable: Rs." + totalBill);
            } else {
                throw new InvalidQuantityException("Invalid quantity! Quantity must be greater than zero.");
            }
        } 
        catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid numerical input.");
        } 
        catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        finally {
            sc.close();
            System.out.println("Program executed...");
        }
    }
}