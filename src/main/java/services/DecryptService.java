package services;

import com.google.gson.JsonElement;

public class DecryptService {
    static DecryptService decryptService;

    public static DecryptService getInstance(){
        if (decryptService != null){
            decryptService = new DecryptService();
        }
        return decryptService;
    }

//    TODO: Choose a Token
    private String DECRYPT_TOKEN = "ID0NTH4VE4T0K3N";

    public JsonElement deCryptData(JsonElement jsonElement){
         int aswer = jsonElement.hashCode();

        return jsonElement;
    }

}
