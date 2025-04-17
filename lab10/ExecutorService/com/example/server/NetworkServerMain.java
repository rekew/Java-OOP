import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkServerMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int port = 10000; port <= 10009; port++) {
            int currentPort = port;
            executor.submit(() -> {
                try (ServerSocket serverSocket = new ServerSocket(currentPort)) {
                    System.out.println("Server running on port: " + currentPort);
                    while (true) {
                        try (Socket clientSocket = serverSocket.accept();
                             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                            out.println("Price from server at port " + currentPort + " is $" + (Math.random() * 100));
                        } catch (IOException e) {
                            System.err.println("Error handling client on port " + currentPort + ": " + e.getMessage());
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Server exception on port " + currentPort + ": " + e.getMessage());
                }
            });
        }
    }
}
