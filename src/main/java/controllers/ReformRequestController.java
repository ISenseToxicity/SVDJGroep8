package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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


    public JsonArray reformSendRequest(JsonElement requestJson, String className, String duty) {
        JsonElement encryptedJsonRequest = encryptTheRequest(requestJson);
        /*Receive the Answer                  Send the Answer*/
//        if(readyToSendRequest(encryptedJsonRequest, className, duty) != null) {
        /*Decrypt the answer*/
//        deCryptTheRequest(receiveAnswerRequest);
            return RevertToJsonElement(readyToSendRequest(encryptedJsonRequest, className, duty), className);
//        }
//        return null;

    }

    /**
     *  Turns the given String to a JsonObject
     * @param request
     * @param classname
     * @return
     */
    public JsonArray RevertToJsonElement(String request, String classname) {

        return new Gson().fromJson(request, JsonArray.class);
    }

    private String readyToSendRequest(JsonElement encryptedJsonRequest, String className,String duty) {
        String encryptedJsonAnswer = RequestDAO.getInstance().sendRequest(encryptedJsonRequest,className, duty);
        return encryptedJsonAnswer;
    }


    /*Encrypt and Decrypt the Request*/
    private JsonElement encryptTheRequest(JsonElement requestJson) {
        return encryptService.encryptData(requestJson);
    }

    private JsonArray deCryptTheRequest(JsonArray requestJson) {
        return decryptService.deCryptData(requestJson);
    }
}
