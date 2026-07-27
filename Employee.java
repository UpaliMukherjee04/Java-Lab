import java.util.*;
public class Employee {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Employee ID:");
        String id=sc.next();
        System.out.println("Enter Employee basic salary:");
        Float basic_sal=sc.nextFloat();
        System.out.println("Enter Employee bonus:");
        Float bonus=sc.nextFloat();
        float net=basic_sal+bonus;
        System.out.println("Net Salary of Employee "+id+" is:"+net);
        sc.close();


    }
}
