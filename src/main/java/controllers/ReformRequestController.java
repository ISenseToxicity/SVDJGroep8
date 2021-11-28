package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
     * @param classname
     * @return
     */
    public JsonArray RevertToJsonElement(String request, String classname) {
        return new Gson().fromJson(request, JsonArray.class);
    }

    public JsonArray readyToSendRequest(Request readyToEncryptRequest, String className) {
//        JsonElement encryptedJsonRequest = encryptTheRequest(readyToEncryptRequest);
        String encryptedJsonAnswer = RequestDAO.getInstance().sendRequest(readyToEncryptRequest, className, readyToEncryptRequest.getDuty(), readyToEncryptRequest.getSpecific());
        return RevertToJsonElement(encryptedJsonAnswer, className);
    }


    /*Encrypt and Decrypt the Request*/
    private JsonElement encryptTheRequest(Request request) {
        return encryptService.encryptData(request);
    }

    private JsonArray deCryptTheRequest(JsonArray requestJson) {
        return decryptService.deCryptData(requestJson);
    }
}
