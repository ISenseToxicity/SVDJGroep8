package controllers;

import com.google.gson.JsonElement;
import models.Request;
import services.ConstructionService;
import services.DeconstructionService;

import java.util.HashMap;

public class RequestController implements Controller {

    ConstructionService constructionService = ConstructionService.getInstance();
    DeconstructionService deconstructionService = DeconstructionService.getInstance();

    public void createNewRequest(HashMap<String, String> variables, String duty) {

        /*Make the request*/
        Request request = new Request(duty, variables, false);

        /*convert the new request to JSON*/
         JsonElement jsonRequest  = convertToNewData(request);
        /*Send the Request*/         /*Receive the Request*/
         JsonElement receiveRequest = reformtoSendRequest(jsonRequest);

         HashMap<String, String> requestAnswer = decryptRecvedRequest(receiveRequest);

//         ToDo: See How to check where the answer Goes Back to and what it has
        /*Send answerRequestBack*/
//        return requestAnswer;
    }

    private HashMap<String, String> decryptRecvedRequest(JsonElement receiveRequest) {
         HashMap<String,String> requestAnswer = deconstructionService.deConstructJSON(receiveRequest);
        return requestAnswer;
    }

    private JsonElement reformtoSendRequest(JsonElement request) {
        JsonElement jsonAnswer = ReformRequestController.getInstance().reformSendRequest(request);
        return jsonAnswer;
    }

    public JsonElement convertToNewData(Request request) {
        ConstructionService constructionService = new ConstructionService();
        JsonElement JsonRequest = constructionService.constructJSON(request);

        return JsonRequest;
    }
}
