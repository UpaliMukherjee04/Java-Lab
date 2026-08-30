import java.util.Scanner;

class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {
        super(message);
    }
}

public class Voting {

    static void checkAge(int age) throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote.");
        }

        System.out.println("You are eligible to vote! Age: " + age);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            checkAge(age);

        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());

        } finally {
            System.out.println("Program Ended.");
            sc.close();
        }
    }
}