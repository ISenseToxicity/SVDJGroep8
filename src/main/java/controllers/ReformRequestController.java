package controllers;

import com.google.gson.JsonElement;
import com.itextpdf.awt.geom.misc.HashCode;
import daos.RequestDAO;
import services.DecryptService;
import services.EncryptService;

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


    public HashCode reformSendRequest(JsonElement requestJson) {

        JsonElement encryptedJsonRequest = encryptTheRequest(requestJson);

        /*Receive the Answer                  Send the Answer*/
        HashCode receiveAnswerRequest = readyToSendRequest(encryptedJsonRequest);

                /*Decrypt the answer*/
        return deCryptTheRequest(receiveAnswerRequest);
    }

    private HashCode readyToSendRequest(JsonElement encryptedJsonRequest) {
        HashCode encryptedJsonAnswer = null;
//        encryptedJsonAnswer = RequestDAO.getInstance().sendRequest(encryptedJsonRequest);
        return encryptedJsonAnswer;
    }


    /*Encrypt and Decrypt the Request*/
    private JsonElement encryptTheRequest(JsonElement requestJson) {
        return encryptService.encryptData(requestJson);
    }

    private HashCode deCryptTheRequest(HashCode requestJson) {
        return decryptService.deCryptData(requestJson);
    }
}
