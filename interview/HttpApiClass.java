package interview;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpApiClass {
        public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
                // Create an HttpClient object
                HttpClient client = HttpClient.newHttpClient();

                // Create an HttpRequest object with the specified URI
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                        .build();

                // Send the request asynchronously and get a CompletableFuture object
                CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

                // Handle the response when it is completed
                future.thenAccept(response -> {
                        // Print the status code and the body of the response
                        System.out.println(response.statusCode());
                        System.out.println(response.body());
                });

                // Wait for the future to complete
                future.join();
        }
}
