package daos;

import com.google.gson.JsonElement;
import models.Request;
import services.ParameterStringBuilder;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Locale;
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
     * @return requestAnswer
     * @throws IOException
     * @author Eefje | AntiEevee
     */
    public String sendRequest(Request readyRequest, String className, String duty, String specific) {
        String newRequest = null;
        try {
            setconectionSpecifics(className, duty, specific);
            if (!duty.equals("GET")) {
                formRequest(readyRequest, className);
            }
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
    private void formRequest(Request jsonRequest, String className) throws IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(className.toLowerCase(), jsonRequest.toString());
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        for(Object item: jsonRequest.getGivenVariables()){
            out.writeBytes(item.toString());
        }
        out.flush();
        out.close();
    }

    private void setconectionSpecifics(String className, String duty, String specific) throws ProtocolException, MalformedURLException {
        try {
            url = new URL("http://localhost:8080/" + className.toLowerCase());
            if(!specific.equals("")) {
                url = new URL(url.toString()+ "/" + specific);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("content-type", "application/json; charset=utf8");
            con.setRequestMethod(duty);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
