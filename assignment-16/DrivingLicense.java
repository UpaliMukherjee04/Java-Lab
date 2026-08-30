import java.util.Scanner;

class UnderAgeException extends Exception {

    UnderAgeException(String message) {
        super(message);
    }
}

public class DrivingLicense {

    static void checkEligibility(int age) throws UnderAgeException {

        if (age < 18) {
            throw new UnderAgeException("You must be at least 18 years old to apply for a driving license.");
        }

        System.out.println("You are eligible for a driving license!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkEligibility(age);

        } catch (UnderAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());

        } finally {
            System.out.println("Program Ended.");
            sc.close();
        }
    }
}