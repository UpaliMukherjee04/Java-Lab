import java.util.*;

class FoodOrder {
    private String customerName = "Ravi Kumar";
    private String foodItem = "Paneer Butter Masala";
    private Integer quantity = 2;
    private Double price = 250.0;

    class OrderDetails {
        void displayOrderDetails() {
            System.out.println("Customer name: " + customerName);
            System.out.println("Food item: " + foodItem);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per item: " + price);
        }
    }
}

interface DeliveryStatus {
    void updateStatus();
}

public class FoodDelivery {
    public static void main(String args[]) {
        FoodOrder order = new FoodOrder();
        FoodOrder.OrderDetails details = order.new OrderDetails();
        details.displayOrderDetails();

        DeliveryStatus status = new DeliveryStatus() {
            public void updateStatus() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter current delivery status (Preparing/Out for Delivery/Delivered):");
                String currentStatus = sc.nextLine();
                System.out.println("Enter estimated delivery time (in minutes):");
                int eta = sc.nextInt();
                System.out.println("Delivery Status: " + currentStatus);
                System.out.println("Estimated time remaining: " + eta + " minutes");
                sc.close();
            }
        };
        status.updateStatus();
    }
}