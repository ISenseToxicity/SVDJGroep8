package services;

import com.google.gson.JsonElement;

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

        public JsonElement encryptData(JsonElement jsonElement) {
//        Todo: Write Decrypt service

            return jsonElement;
        }

}