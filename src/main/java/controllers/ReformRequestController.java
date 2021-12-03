package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import daos.RequestDAO;
import models.Request;
import services.DecryptService;
import services.EncryptService;

public class ReformRequestController implements Controller {
    EncryptService encryptService = EncryptService.getInstance();
    DecryptService decryptService = DecryptService.getInstance();

    static ReformRequestController reformRequestController;

    public static ReformRequestController getInstance() {
        if (reformRequestController == null) {
            reformRequestController = new ReformRequestController();
        }
        return reformRequestController;
    }

    /**
     * Turns the given String to a JsonObject
     *
     * @param request
     * @param oldRequest
     * @return
     */
    public JsonArray RevertToJsonElement(String request, Request oldRequest) {
        if(oldRequest.getDuty().equals("PUT") || (oldRequest.getDuty().equals("GET") && !oldRequest.getSpecific().equals("all"))){
            JsonObject item = new Gson().fromJson(request, JsonObject.class);
            JsonArray jsArray = new JsonArray();
            jsArray.add(item);
            return jsArray;
        }
        return new Gson().fromJson(request, JsonArray.class);
    }

    public JsonArray readyToSendRequest(Request readyToEncryptRequest, String className) {
//        JsonElement encryptedJsonRequest = encryptTheRequest(readyToEncryptRequest);
        String encryptedJsonAnswer = RequestDAO.getInstance().sendRequest(readyToEncryptRequest, className, readyToEncryptRequest.getDuty(), readyToEncryptRequest.getSpecific());
        return RevertToJsonElement(encryptedJsonAnswer, readyToEncryptRequest);
    }


    /*Encrypt and Decrypt the Request*/
    private JsonElement encryptTheRequest(Request request) {
        return encryptService.encryptData(request);
    }

    private JsonArray deCryptTheRequest(JsonArray requestJson) {
        return decryptService.deCryptData(requestJson);
    }
}
