package interview;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpApiExample {

        public static void main(String[] args) throws IOException {
                URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                        InputStream responseStream = connection.getInputStream();
                        byte[] responseBytes = new byte[responseStream.available()];
                        responseStream.read(responseBytes);
                        String responseString = new String(responseBytes);

                        System.out.println(responseString);
                } else {
                        System.out.println("Error: " + responseCode);
                }
        }
}

