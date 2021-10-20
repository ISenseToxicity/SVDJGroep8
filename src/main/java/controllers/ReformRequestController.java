package controllers;

import Exceptions.DataBaseException;
import com.google.gson.JsonElement;
import daos.RequestDAO;
import models.Request;
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


    public JsonElement reformSendRequest(JsonElement requestJson) {

        JsonElement encryptedJsonRequest = encryptTheRequest(requestJson);

        /*Receive the Answer                  Send the Answer*/
        JsonElement receiveAnswerRequest = readyToSendRequest(encryptedJsonRequest);

                /*Decrypt the answer*/
        return deCryptTheRequest(receiveAnswerRequest);
    }

    private JsonElement readyToSendRequest(JsonElement encryptedJsonRequest) {
        JsonElement encryptedJsonAnswer = null;
        encryptedJsonAnswer = RequestDAO.getInstance().sendRequest(encryptedJsonRequest);
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
