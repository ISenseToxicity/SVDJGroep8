package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostService {
    public static PostService postService;

    //TODO .env maken voor URL en dan niet als input pakken
    public void post(String URL, String input) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "text/plain; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(input))
                .build();

        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }

        //does nothing with response atm
        System.out.println(httpResponse.body());
    }

    public static PostService getInstance() {
        if (postService == null) {
            postService = new PostService();
        }
        return postService;
    }
}
