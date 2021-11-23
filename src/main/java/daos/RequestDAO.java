package daos;

import com.google.gson.JsonElement;
import services.ParameterStringBuilder;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestDAO {
    static RequestDAO requestDAO;
    private URL url;
    private HttpURLConnection con;

    public static RequestDAO getInstance() {
        if (requestDAO == null) {
            requestDAO = new RequestDAO();
        }
        return requestDAO;
    }


    /**
     * Sends request in diffrent Methods
     *
     * @param readyRequest
     * @return requestAnswer
     * @throws IOException
     * @author Eefje | AntiEevee
     */
    public String sendRequest(JsonElement readyRequest, String className, String duty, String specific) {
        String newRequest = null;
        try {
            setconectionSpecifics(className, duty, specific);
            formRequest(readyRequest, className);
            newRequest = readRequest();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.disconnect();
        }
        return newRequest;
    }


    private String readRequest() throws IOException {
        StringBuilder content = new StringBuilder();
        InputStream inputStream = con.getInputStream();
        Scanner scan = new Scanner(inputStream);
        while (scan.hasNext()) {
            content.append(scan.next());

        }
        if (con.getResponseCode() == 200) {

            while (scan.hasNext()) {
                content.append(scan.next());
            }

        }
        inputStream.close();
        return content.toString();
    }

    /**
     * sets the request ready
     *
     * @throws IOException
     * @
     */
    private void formRequest(JsonElement jsonElement, String className) throws IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(className, jsonElement.getAsString());

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();
    }

    private void setconectionSpecifics(String className, String duty, String specific) throws ProtocolException, MalformedURLException {
        try {
            url = new URL("http://localhost:8080/" + className + "/" + specific);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("content-type", "application/json; charset=utf8");
            con.setRequestMethod(duty);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
