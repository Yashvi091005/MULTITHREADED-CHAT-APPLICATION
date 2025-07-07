import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 1234;
    private static Set<Socket> clientSockets = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("💬 Server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                clientSockets.add(socket);
                System.out.println("✅ New client connected: " + socket);

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("❌ Server error: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("📩 Message received: " + msg);
                    broadcast(msg, socket);
                }
            } catch (IOException e) {
                System.err.println("⚠️ Client disconnected.");
            } finally {
                try {
                    clientSockets.remove(socket);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Send message to all clients except the sender
        private void broadcast(String message, Socket sender) {
            for (Socket client : clientSockets) {
                if (!client.equals(sender)) {
                    try {
                        new PrintWriter(client.getOutputStream(), true).println(message);
                    } catch (IOException e) {
                        System.err.println("❌ Failed to broadcast: " + e.getMessage());
                    }
                }
            }
        }
    }
}
