import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Locate RMI Registry running on localhost at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup stub for CalculatorService
            CalculatorService calc = (CalculatorService) registry.lookup("CalculatorService");

            // Perform remote method calls
            double num1 = 20.5;
            double num2 = 5.5;

            System.out.println("=== RMI Calculator Client ===");
            System.out.println(num1 + " + " + num2 + " = " + calc.add(num1, num2));
            System.out.println(num1 + " - " + num2 + " = " + calc.subtract(num1, num2));
            System.out.println(num1 + " * " + num2 + " = " + calc.multiply(num1, num2));
            System.out.println(num1 + " / " + num2 + " = " + calc.divide(num1, num2));

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}