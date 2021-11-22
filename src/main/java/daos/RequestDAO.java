package daos;

import com.google.gson.JsonElement;
import services.ParameterStringBuilder;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

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
    public String sendRequest(JsonElement readyRequest, String className, String duty) {
        String newRequest = null;
        try {
            setconectionSpecifics(className, duty);
            formRequest(readyRequest, className);
            newRequest = readRequest();
            con.disconnect();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newRequest;
    }


    private String readRequest() throws IOException {
        String answer = null;
        InputStream inputStream = con.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);
        StringBuilder content = new StringBuilder();

        if (con.getResponseMessage().equals("200")) {
            while ((answer = in.readLine()) != null) {
                content.append(answer);
            }
            in.close();
        }
        System.out.println(answer);
        return answer;
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

//    /**
//     * Vormt de cookies waaraan de request kan worden herkent.
//     * @return Cookies
//     */
//    private StringUtils developCookies() {
//        String cookiesHeader = con.getHeaderField("Set-Cookie");
//        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
//
//        cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
//        Optional<HttpCookie> usernameCookie = cookies.stream()
//                .findAny().filter(cookie -> cookie.getName().equals("username"));
//        if (usernameCookie == null) {
//            cookieManager.getCookieStore().add(null, new HttpCookie("username", "john"));
//        }
//        return cookies;
//    }

    private void setconectionSpecifics(String className, String duty) throws ProtocolException, MalformedURLException {
        try {
            url = new URL("http://localhost:8080/" + className);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json; charset=utf8");
            con.setRequestMethod(duty);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
