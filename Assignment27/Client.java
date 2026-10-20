import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Localhost
        int port = 5001;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to the server!");

            // Streams for reading and writing data
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;

            while (true) {
                // Send message to server
                System.out.print("Client: ");
                clientMessage = consoleInput.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Closing connection...");
                    break;
                }

                // Read message from server
                serverMessage = in.readLine();
                if (serverMessage == null || serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected the chat.");
                    break;
                }
                System.out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}