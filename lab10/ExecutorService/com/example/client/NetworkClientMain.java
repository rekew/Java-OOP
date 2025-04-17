import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class NetworkClientMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();

        for (int port = 10000; port <= 10009; port++) {
            RequestResponse request = new RequestResponse("localhost", port);
            NetworkClientCallable callable = new NetworkClientCallable(request);
            Future<RequestResponse> future = executor.submit(callable);
            callables.put(request, future);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        callables.forEach((request, future) -> {
            try {
                RequestResponse response = future.get();
                System.out.println("Response from " + response.getHost() + ":" + response.getPort() +
                                   " - " + response.getResponse());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Failed to get response from " + request.getPort() + ": " + e.getMessage());
            }
        });
    }
}
