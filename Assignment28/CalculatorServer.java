import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create remote object instance
            CalculatorService service = new CalculatorServiceImpl();

            // Create and start RMI Registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object stub in the registry
            registry.rebind("CalculatorService", service);

            System.out.println("Calculator RMI Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}