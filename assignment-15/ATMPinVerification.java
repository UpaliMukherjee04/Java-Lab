import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

public class ATMPinVerification {
    
    private static final int CORRECT_PIN = 4321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your 4-digit ATM PIN: ");
            int enteredPin = sc.nextInt();

            
            if (enteredPin == CORRECT_PIN) {
                System.out.println("PIN verified successfully! Access granted.");
            } else {
                throw new InvalidPINException("Incorrect PIN entered. Access denied.");
            }
        } 
        catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format. Please enter numeric digits only.");
        } 
        catch (InvalidPINException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        finally {
            sc.close();
            System.out.println("PIN verification process completed.");
        }
    }
}