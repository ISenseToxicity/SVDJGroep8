package daos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.itextpdf.awt.geom.misc.HashCode;
import services.GetService;
import services.ParameterStringBuilder;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
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
     * Verzend een request om alle informatie in een keer te krijgen,
     * opent een connectie met de rest api. En haalt vervolgens de informatie op.
     *
     * @param readyRequest
     * @return requestAnswer
     * @throws IOException
     * @author Eefje | AntiEevee
     */
    public HashCode sendRequest(JsonElement readyRequest, String className) {
        try {
            setconectionSpecifics();
            url.openConnection();
            formRequest(readyRequest, className);
            readRequest();
            con.disconnect();
        } catch (IOException ioException) {
            ioException.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }


    private void readRequest() throws IOException {
        if (con.getResponseMessage().equals("200")) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        }
    }

    /**
     * sets the request ready
     *
     * @throws IOException
     */
    private void formRequest(JsonElement jsonElement, String className) throws IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(className, jsonElement.getAsString());

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();
//      SetHeader of Request
        String contentType = con.getHeaderField("SVDJ/" + className);
        con.setRequestProperty(contentType, "application/json");
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

    private void setconectionSpecifics() throws ProtocolException, MalformedURLException {
        url = new URL("http://localhost:8080/");
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

    }

}
