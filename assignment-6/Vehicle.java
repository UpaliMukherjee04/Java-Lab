import java.util.*;
class Vehicles{
    private String cname="Mercedes";
    private String color="White";
    private Integer price=6000000;
    class Details{
        void displayDetails(){
            System.out.println("Car name:"+cname);
            System.out.println("Car color:"+color);
            System.out.println("Car price:"+price);
        }
    }
}
interface Action{
    void calculateBill();
}

public class Vehicle {
    public static void main(String args[]){
        Vehicles v = new Vehicles();
        Vehicles.Details det = v.new Details();
        det.displayDetails();

        Action obj = new Action(){
            public void calculateBill(){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter price:");
                float price = sc.nextFloat();
                System.out.println("Enter tax in %:");
                float tax = sc.nextFloat();
                float total = price + (tax / 100) * price;
                System.out.println("Total bill=" + total);
                sc.close();
            }
        };
        obj.calculateBill();
        
    }
}
