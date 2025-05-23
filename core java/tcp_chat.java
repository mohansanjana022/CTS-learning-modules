//server
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in)
            );

            String clientMsg, serverMsg;
            while ((clientMsg = in.readLine()) != null) {
                System.out.println("Client: " + clientMsg);
                System.out.print("Server: ");
                serverMsg = userInput.readLine();
                out.println(serverMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//client

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in)
            );

            String clientMsg, serverMsg;
            while (true) {
                System.out.print("Client: ");
                clientMsg = userInput.readLine();
                out.println(clientMsg);
                serverMsg = in.readLine();
                System.out.println("Server: " + serverMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



