package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class PostService {
    public static PostService postService;

    public void post() throws IOException, InterruptedException {
        HashMap<String,String> values = new HashMap<String,String>();

        //placeholder information TODO: make this variable input or ask for/create JSON as inputString
        values.put("name","Rob");
        values.put("biggest","boi");

        String requestBody = values.toString(); //should be a JSON string

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("Website url")) //TODO set final API parameter and get trail from input
                .header("Content-Type", "text/plain; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        //TODO: do something with response
        System.out.println(httpResponse.body());
    }

    public static PostService getInstance() {
        if (postService == null) {
            postService = new PostService();
        }
        return postService;
    }
}
