package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import daos.RequestDAO;
import org.junit.Assert;
import services.DecryptService;
import services.EncryptService;

import java.io.IOException;

public class ReformRequestController implements Controller {
    EncryptService encryptService = EncryptService.getInstance();
    DecryptService decryptService = DecryptService.getInstance();

    static ReformRequestController reformRequestController;

    public static ReformRequestController getInstance(){
        if(reformRequestController == null){
            reformRequestController = new ReformRequestController();
        }
        return reformRequestController;
    }


    public JsonElement reformSendRequest(JsonElement requestJson, String className) {
        JsonElement encryptedJsonRequest = encryptTheRequest(requestJson);
        /*Receive the Answer                  Send the Answer*/
        JsonElement receiveAnswerRequest = RevertToJsonElement(readyToSendRequest(encryptedJsonRequest, className), className);

                /*Decrypt the answer*/
        return deCryptTheRequest(receiveAnswerRequest);
    }

    /**
     *  Turns the given String to a JsonObject
     * @param request
     * @param classname
     * @return
     */
    private JsonElement RevertToJsonElement(String request, String classname) {
        JsonObject convertedToJson = new Gson().fromJson(request, JsonObject.class);

        Assert.assertTrue(convertedToJson.isJsonObject());
        Assert.assertEquals(convertedToJson.get("name").getAsString(), classname);
        Assert.assertTrue(convertedToJson.get("java").getAsBoolean());
        return  convertedToJson;
    }

    private String readyToSendRequest(JsonElement encryptedJsonRequest, String className) {
        String encryptedJsonAnswer = RequestDAO.getInstance().sendRequest(encryptedJsonRequest,className);
        return encryptedJsonAnswer;
    }


    /*Encrypt and Decrypt the Request*/
    private JsonElement encryptTheRequest(JsonElement requestJson) {
        return encryptService.encryptData(requestJson);
    }

    private JsonElement deCryptTheRequest(JsonElement requestJson) {
        return decryptService.deCryptData(requestJson);
    }
}
