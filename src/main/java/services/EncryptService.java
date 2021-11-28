package services;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import models.Request;

public class EncryptService {
    static EncryptService encryptService;

    public static EncryptService getInstance(){
        if (encryptService == null){
            encryptService = new EncryptService();
        }
        return encryptService;
    }

        //    TODO: Choose a Token
        private String DECRYPT_TOKEN = "ID0NTH4VE4T0K3N";

        private Request deleteIdOfRequest(Request request){

            for(Object postRequest :request.getGivenVariables()){
                postRequest.toString();
            }
            return request;
        }


        public JsonElement encryptData(Request request) {
            request.getGivenVariables();

            JsonElement jsonElement = JsonParser.parseString(request.toString());
            return jsonElement;
        }

}