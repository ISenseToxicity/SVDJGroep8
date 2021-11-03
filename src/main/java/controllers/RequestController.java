package controllers;

import com.google.gson.JsonElement;
import com.itextpdf.awt.geom.misc.HashCode;
import models.Model;
import models.Request;
import services.*;
import services.ConstructionService;

import java.util.ArrayList;
import java.util.HashMap;

public class RequestController implements Controller {
    private final ControllerRegistry controllerRegistry = ControllerRegistry.getInstance();

    private final ReformRequestController reformRequestController = ReformRequestController.getInstance();
    private final ConstructionService constructionService = ConstructionService.getInstance();
    private final DeconstructionService deconstructionService = DeconstructionService.getInstance();

    public ArrayList<ArrayList<Model>> makeRequestOfReceivingQuestions() {
        Request request = createNewRequest(null, "GetAllQuestions");
        HashMap<String, ArrayList<Model>> answer = getAnswerNewRequest(request);
        ArrayList<ArrayList<Model>> fullQuestionList = setCorrectFormatAnswer(answer);
        return fullQuestionList;
    }

    public ArrayList<ArrayList<Model>> makeRequestOfSending(ArrayList<Model> variables, String duty, String nameClass) {
        HashMap<String, ArrayList<Model>> hmVariables = new HashMap<>();
        hmVariables.put(nameClass, variables);
        Request request = createNewRequest(hmVariables, duty);
        HashMap<String, ArrayList<Model>> answer = getAnswerNewRequest(request);
        ArrayList<ArrayList<Model>> fullQuestionList = setCorrectFormatAnswer(answer);
        return fullQuestionList;
    }

    private ArrayList<ArrayList<Model>> setCorrectFormatAnswer(HashMap<String, ArrayList<Model>> answer) {
        ArrayList<ArrayList<Model>> arrayList = new ArrayList<>();
        for (ArrayList<Model> model : answer.values()) {
            arrayList.add(model);
        }
        return arrayList;
    }

    private HashMap<String, ArrayList<Model>> getAnswerNewRequest(Request request) {
        JsonElement jsonRequest = convertToNewData(request);
        HashCode receiveRequest = reformtoSendRequest(jsonRequest);
        HashMap<String, ArrayList<Model>> requestAnswer = decryptRecvedRequest(receiveRequest);
        return requestAnswer;
    }

    private Request createNewRequest(HashMap<String, ArrayList<Model>> variables, String duty) {
        Request request = new Request(duty, variables, false);
        return request;
    }

    private HashMap<String, ArrayList<Model>> decryptRecvedRequest(HashCode receiveRequest) {
        HashMap<String, ArrayList<Model>> requestAnswer = deconstructionService.deConstructJSON(receiveRequest);
        return requestAnswer;
    }

    private HashCode reformtoSendRequest(JsonElement request) {
        return reformRequestController.reformSendRequest(request);
    }

    public JsonElement convertToNewData(Request request) {
        return constructionService.constructJSON(request);
    }
}
