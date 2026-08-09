
import java.util.*;
//1.Create an abstract Payment class and implement Credit Card and UPI payment classes.
abstract class Payment{
    Scanner sc = new Scanner (System.in);
    abstract void paymentStatus();
    abstract void paymentAmount();
}
class UPI extends Payment{
    void paymentStatus(){
        
        System.out.println("Is payment completed?\n1. Yes\n2.No\nEnter choice:");
        int status=sc.nextInt();
        switch (status){
            case 1 : System.out.println("Payment status: completed and verified by UPI"); break;
            case 2: System.out.println("Payment status:failed to connect to UPI");break;
            default: System.out.println("Invalid input");
        }
    }
    void paymentAmount(){
    System.out.println("Enter amount paid");
    float amount = sc.nextFloat();
    System.out.println("Payment amount through UPI:"+amount);

    }
    
}
class CreditCard extends Payment{
    void paymentStatus(){
        System.out.println("Is payment completed?\n1. Yes\n2.No\nEnter choice:");
        int status=sc.nextInt();
        switch (status){
            case 1 : System.out.println("Payment status: completed and verified by Credit Card"); break;
            case 2: System.out.println("Payment status:failed to authenticate credit card");break;
            default: System.out.println("Invalid input");
        }
    }
    void paymentAmount(){
    System.out.println("Enter amount paid");
    float amount = sc.nextFloat();
    System.out.println("Payment amount through Credit Card:"+amount);

    }
}

public class PaymentAbstract{
    public static void main(String args[]){
        UPI u = new UPI();
        System.out.println("\nUPI methods:");
        u.paymentAmount();
        u.paymentStatus();
        CreditCard cc = new CreditCard();
        System.out.println("\nCredit Card Methods:");
        cc.paymentAmount();
        cc.paymentStatus();
    }
}