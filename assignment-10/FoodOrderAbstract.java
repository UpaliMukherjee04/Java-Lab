import java.util.*;

abstract class FoodOrder {
    Scanner sc = new Scanner(System.in);
    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {
    void calculateBill() {
        System.out.println("Enter number of items ordered:");
        int items = sc.nextInt();

        System.out.println("Enter price per item:");
        float pricePerItem = sc.nextFloat();

        float subtotal = items * pricePerItem;

        float serviceChargeRate = 0.10f; 
        float taxRate = 0.05f;           

        float serviceCharge = subtotal * serviceChargeRate;
        float tax = subtotal * taxRate;
        float total = subtotal + serviceCharge + tax;

        System.out.println("\nDine-In Bill:");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Service Charge (10%): " + serviceCharge);
        System.out.println("Tax (5%): " + tax);
        System.out.println("Total Bill: " + total);
    }
}

class TakeAwayOrder extends FoodOrder {
    void calculateBill() {
        System.out.println("Enter number of items ordered:");
        int items = sc.nextInt();

        System.out.println("Enter price per item:");
        float pricePerItem = sc.nextFloat();

        float subtotal = items * pricePerItem;
        float packagingCharge = 20.0f; 
        float taxRate = 0.05f;        

        float tax = subtotal * taxRate;
        float total = subtotal + packagingCharge + tax;

        System.out.println("\nTake-Away Bill:");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Packaging Charge: " + packagingCharge);
        System.out.println("Tax (5%): " + tax);
        System.out.println("Total Bill: " + total);
    }
}

public class FoodOrderAbstract{
    public static void main(String args[]) {
        DineInOrder dine = new DineInOrder();
        System.out.println("Dine-In Order:");
        dine.calculateBill();

        TakeAwayOrder takeAway = new TakeAwayOrder();
        System.out.println("\nTake-Away Order:");
        takeAway.calculateBill();
    }
}