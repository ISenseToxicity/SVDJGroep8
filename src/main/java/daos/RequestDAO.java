package daos;

import com.google.gson.JsonElement;

public class RequestDAO {
    static RequestDAO requestDAO;

    public static RequestDAO getInstance() {
        if (requestDAO == null) {
            requestDAO = new RequestDAO();
        }
        return requestDAO;
    }
    public JsonElement sendRequest( JsonElement readyRequest){

//        Todo : How to send it with a HTML request to BAckend
        JsonElement answer = new JsonElement() {
            @Override
            public JsonElement deepCopy() {
                return null;
            }
        };
        return answer;
    }

}
