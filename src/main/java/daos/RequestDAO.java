package daos;

import com.google.gson.JsonElement;
import com.itextpdf.text.pdf.StringUtils;
import services.ParameterStringBuilder;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RequestDAO {
    static RequestDAO requestDAO;

    URL url;
    HttpURLConnection con;

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
    public JsonElement sendRequest(JsonElement readyRequest) throws IOException {

//        BASED OFF https://www.baeldung.com/java-http-request
//        Todo :finnish
        try {
//          set Connection
            setconectionSpecifics();
            url.openConnection();
//          Add what to request
            formRequest();
//            Give cookies
            StringUtils cookies = developCookies();
            con.disconnect();
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Cookie", StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));
        } catch (Exception e) {

        }
        return null;
    }
    /**
     * sets the request ready
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

    /**
     * Vormt de cookies waaraan de request kan worden herkent.
     * @return Cookies
     */
    private StringUtils developCookies() {
        String cookiesHeader = con.getHeaderField("Set-Cookie");
        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);

        cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
        Optional<HttpCookie> usernameCookie = cookies.stream()
                .findAny().filter(cookie -> cookie.getName().equals("username"));
        if (usernameCookie == null) {
            cookieManager.getCookieStore().add(null, new HttpCookie("username", "john"));
        }
        return cookies;
    }

    private void setconectionSpecifics() throws ProtocolException {
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

    }

}
