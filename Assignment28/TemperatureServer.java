import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            
            TemperatureConverter converter = new TemperatureConverterImpl();

            Registry registry = LocateRegistry.createRegistry(1099);

            
            registry.rebind("TempConverter", converter);

            System.out.println("Temperature Converter RMI Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}