import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {
    private RequestResponse requestResponse;

    public NetworkClientCallable(RequestResponse requestResponse) {
        this.requestResponse = requestResponse;
    }

    @Override
    public RequestResponse call() {
        try (Socket socket = new Socket(requestResponse.getHost(), requestResponse.getPort());
             Scanner scanner = new Scanner(socket.getInputStream())) {

            if (scanner.hasNextLine()) {
                String response = scanner.nextLine();
                requestResponse.setResponse(response);
            }
        } catch (IOException e) {
            requestResponse.setResponse("Error: " + e.getMessage());
        }

        return requestResponse;
    }
}
