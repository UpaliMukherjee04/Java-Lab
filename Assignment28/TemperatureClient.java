import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            TemperatureConverter tempService = (TemperatureConverter) registry.lookup("TempConverter");

            Scanner scanner = new Scanner(System.in);
            System.out.println("=== RMI Temperature Converter ===");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");
            System.out.print("Choose an option (1 or 2): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter temperature in Celsius: ");
                double c = scanner.nextDouble();
                double f = tempService.celsiusToFahrenheit(c);
                System.out.printf("%.2f °C = %.2f °F%n", c, f);
            } else if (choice == 2) {
                System.out.print("Enter temperature in Fahrenheit: ");
                double f = scanner.nextDouble();
                double c = tempService.fahrenheitToCelsius(f);
                System.out.printf("%.2f °F = %.2f °C%n", f, c);
            } else {
                System.out.println("Invalid choice.");
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}