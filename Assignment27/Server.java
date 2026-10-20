import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args) {
        int port = 5001; 
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for a client to connect...");
            
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Streams for reading and writing data
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;

            while (true) {
                // Read message from client
                clientMessage = in.readLine();
                if (clientMessage == null || clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected the chat.");
                    break;
                }
                System.out.println("Client: " + clientMessage);

                // Send message to client
                System.out.print("Server: ");
                serverMessage = consoleInput.readLine();
                out.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Closing connection...");
                    break;
                }
            }

            socket.close();
            System.out.println("Server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}