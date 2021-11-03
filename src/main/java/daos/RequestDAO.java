package daos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.itextpdf.awt.geom.misc.HashCode;
import models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import services.GetService;
import services.ParameterStringBuilder;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RequestDAO {
    static RequestDAO requestDAO;

//    @Autowired
//
//    private final Gson request = new Gson();
//    GetService getService = GetService.getInstance();
//
//
//    public static RequestDAO getInstance() {
//        if (requestDAO == null) {
//            requestDAO = new RequestDAO();
//        }
//        return requestDAO;
//    }
//
////    GetQuestions
//    @GetMapping("/Questions")
//    public Request getQuestions(Request readyRequest){
//                return
//
//    }
//
////    POST results
//    @PostMapping("/AnswerList")
//    public Request getQuestions(Request readyRequest){
//        return;
//
//    }

//    public Request sendRequest(JsonElement jRequest) throws IOException {
//        return request.fromJson(getService.getResponse("http://localhost:8080/question"), Request.getClassName);
//
//    }

    URL url;
    HttpURLConnection con;

    /**
     * Verzend een request om alle informatie in een keer te krijgen,
     * opent een connectie met de rest api. En haalt vervolgens de informatie op.
     *
     * @param readyRequest
     * @return requestAnswer
     * @throws IOException
     * @author Eefje | AntiEevee
     */
    public HashCode sendRequest(JsonElement readyRequest) {
//        BASED OFF https://www.baeldung.com/java-http-request
        try {
//          set Connection
            setconectionSpecifics();
            url.openConnection();
//          Add what to request
            formRequest();
//            Read Request
            readRequest();
//            Give cookies
//            StringUtils cookies = developCookies();
            con.disconnect();
//            con.setRequestProperty("Cookie", StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));
        } catch (IOException ioException){
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
    private void formRequest() throws IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Questions", "question");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

//      SetHeader of Request
        String contentType = con.getHeaderField("GET/Question");
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
