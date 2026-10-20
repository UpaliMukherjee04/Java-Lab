import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Echo Server is listening on port " + port + "...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                
                // Echoing the same line back to client
                out.println("ECHO: " + inputLine);

                if (inputLine.equalsIgnoreCase("bye")) {
                    System.out.println("Client sent 'bye'. Ending session.");
                    break;
                }
            }

            socket.close();
            System.out.println("Echo Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}