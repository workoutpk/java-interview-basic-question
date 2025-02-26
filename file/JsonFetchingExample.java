package file;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class JsonFetchingExample {
    // Method 1: Using Java 11 HttpClient
    public static String fetchUsersWithHttpClient() throws IOException, InterruptedException {
        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .GET()
                .build();

        // Send request and get response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
        // Parse JSON using Jackson ObjectMapper
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(response.body(),
//                objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
    }

    // Method 2: Using Retrofit (Recommended for more complex API interactions)
    /*
    // Retrofit Interface Example
    public interface UserService {
        @GET("users")
        Call<List<User>> getUsers();
    }

    // Retrofit Setup
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build();

    UserService service = retrofit.create(UserService.class);
    */
    public static void main(String[] args) {
        try {
            // Fetch and print users
            String users = fetchUsersWithHttpClient();
            System.out.println(users);
            // Print each user
            //users.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
