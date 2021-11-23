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

        public JsonElement encryptData(Request request) {
//        Todo: Write Decrypt service
            JsonElement jsonElement = JsonParser.parseString(request.toString());
            return jsonElement;
        }

}