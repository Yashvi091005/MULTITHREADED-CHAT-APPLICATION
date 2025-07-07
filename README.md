# MULTITHREADED-CHAT-APPLICATION

COMPANY: CODTECHIT SOLUTIONS

NAME: YASHVI BHALA

INTERNID: YASHVI38684

DOMAIN: JAVA 

DURATION: 6 WEEKS

MENTOR: NEELA SANTOSH

##REPORT ON MULTITHREAD CHAT APPLICATION

🎯 Objective of the Task
The objective of Task 3 was to build a real-time chat application in Java that enables multiple users (clients) to communicate through a centralized server. This application required implementing Java Socket programming with multithreading to ensure simultaneous connections from multiple clients.

This task was meant to simulate how messaging systems, multiplayer games, and collaborative tools work in the background. By completing this, I gained a strong foundation in network programming, client-server architecture, and multi-user communication.

🔧 Technologies and Concepts Used
Java Socket Programming

ServerSocket, Socket for client-server connections

Multithreading using Thread class

BufferedReader and PrintWriter for I/O streams

CLI-based communication

HashSet to track active clients

💻 Structure of the Application
The application consists of two separate Java files:

1. ChatServer.java – The Server
Listens on a specific port (1234)

Accepts new client connections continuously

Spawns a new thread (ClientHandler) for each client

Maintains a list of connected client sockets

Broadcasts received messages to all clients (except sender)

2. ChatClient.java – The Client
Connects to server using IP and port

Takes input from the user via console

Sends user messages to the server

Runs a separate thread to listen to incoming messages

📜 Program Flow
The server starts and waits for client connections.

Each time a client connects, a new thread is started to handle communication.

Clients send messages which are broadcast to all other connected clients.

Each client reads messages from other users in real time and can send messages simultaneously.

The application runs until the user exits or the server is stopped.

🧠 Key Learning Outcomes
Concept	Implementation Details
Multithreading	Each client is managed using a separate thread
Socket programming	Established bidirectional communication
Concurrent connections	Server handles multiple users simultaneously
Real-time communication	Message delivery and broadcast in milliseconds
Resource cleanup	Clients disconnect gracefully and update state

✅ Task Outcome
This task was successfully completed. The server was able to handle multiple clients at once and broadcast their messages efficiently. The clients could chat in real-time, and the chat system functioned without crashes or deadlocks. The input/output streams were efficiently managed using BufferedReader and PrintWriter, and threads were properly isolated for each client.

All code was well-structured and documented for clarity.

📁 Deliverables Submitted
ChatServer.java: Server-side logic with multithreaded message handling

ChatClient.java: Client-side logic with real-time message sending and receiving

Ready-to-run setup with port configuration

📘 Conclusion
Task 3 was a major step in understanding real-world networking in Java. It deepened my understanding of how chat systems, game lobbies, and collaborative tools function behind the scenes. The project taught me how to manage multiple threads, handle socket communication, and ensure smooth data transmission between clients. This task was successfully completed and serves as a solid foundation for advanced networked applications.
