package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetService {
    private static GetService getService;

    public String getResponse(String URL) throws IOException {
        java.net.URL endpointURL = new URL(URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) endpointURL.openConnection();
        httpURLConnection.setRequestMethod("GET");

        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String line = bufferedReader.readLine();

            if (line == null) {
                break;
            }

            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }

    public static GetService getInstance() {
        if (getService == null) {
            getService = new GetService();
        }

        return getService;
    }
}
