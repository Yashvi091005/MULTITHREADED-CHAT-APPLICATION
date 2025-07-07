import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1"; // or localhost
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.println("✅ Connected to the chat server.");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            // Thread to listen to server messages
            Thread readThread = new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("📨 " + response);
                    }
                } catch (IOException e) {
                    System.err.println("🚫 Server disconnected.");
                }
            });

            readThread.start();

            // Main thread for user input
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                out.println(message);
            }

        } catch (IOException e) {
            System.err.println("❌ Connection error: " + e.getMessage());
        }
    }
}
