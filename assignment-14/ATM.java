
import java.util.*;
class InvalidWithdrawalException extends Exception {
    InvalidWithdrawalException(String message) {
        super(message);
    }
}
public class ATM {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter bank balance:");
            float balance = sc.nextFloat();
            System.out.println("Enter Withdrawal Amount:");
            float withdrawalAmount = sc.nextFloat();
            float finalBalance = balance;
            sc.close();

            if (withdrawalAmount<balance){
                finalBalance = balance - withdrawalAmount;
                System.out.println("Amount withdrawn = "+withdrawalAmount);
                System.out.println("Final account balance="+finalBalance);
            }
            else{
                throw new InvalidWithdrawalException ("invalid withdrawal amount");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Enter valid float input");
        }
        catch (InvalidWithdrawalException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Program executed...");
        }
        
    }
}


// 4. Java Program to Demonstrate Exception Handling using try-catch, Nested try-catch, and Multiple Catch Blocks
// import java.util.Scanner;

// public class ExceptionDemo1 {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         try {
//             System.out.print("Enter first number: ");
//             int a = sc.nextInt();

//             System.out.print("Enter second number: ");
//             int b = sc.nextInt();

//             try {
//                 int result = a / b;
//                 System.out.println("Division Result = " + result);

//                 int arr[] = {10, 20, 30};
//                 System.out.println("Array Element = " + arr[5]);

//             } catch (ArrayIndexOutOfBoundsException e) {
//                 System.out.println("Nested Catch: Array index is invalid.");
//             }

//         } catch (ArithmeticException e) {
//             System.out.println("Cannot divide by zero.");
//         } catch (java.util.InputMismatchException e) {
//             System.out.println("Please enter valid integer values.");
//         } catch (Exception e) {
//             System.out.println("General Exception: " + e);
//         }

//         sc.close();
//     }
// }

