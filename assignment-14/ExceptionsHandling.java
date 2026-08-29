
import java.util.*;
public class ExceptionsHandling {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int a = sc.nextInt();
        int b = sc.nextInt();
        try{
            // int result = a/b;
            // System.out.println("division="+result);

            int arr[] = {2,3,4,5};
            System.out.println((arr[5]));

        }
       
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of range");
        }
         catch (Exception e){
            System.out.println("General exception");
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

