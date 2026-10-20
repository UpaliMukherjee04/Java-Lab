import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 6000;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to Echo Server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String userMessage;
            System.out.println("Type your messages below (type 'bye' to exit):");

            while (true) {
                System.out.print("You: ");
                userMessage = consoleInput.readLine();
                
                // Send message to Echo Server
                out.println(userMessage);

                // Receive echoed message
                String echoedResponse = in.readLine();
                System.out.println("Server Response -> " + echoedResponse);

                if (userMessage.equalsIgnoreCase("bye")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}