package controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import models.*;
import services.*;
import services.ConstructionService;

import java.util.ArrayList;

public class RequestController implements Controller {

    private final ReformRequestController reformRequestController = (ReformRequestController) ControllerRegistry.get(ReformRequestController.class);
    private final ConstructionService constructionService = ConstructionService.getInstance();
    private final DeconstructionService deconstructionService = DeconstructionService.getInstance();

    public boolean establishConnection() {
        ArrayList<String> aString = new ArrayList<>();
        Request request = createNewRequest(aString, "all", "GET");
        ArrayList<Category> out = (ArrayList<Category>) getAnswerNewRequest(request, "category");
        return !out.isEmpty();
    }

    /**
     * Make Requests to de Database
     * makeRequestWithClass(class, id/ all, method);
     *
     * @return Wanted database models
     * @author Eefje | AntiEevee
     */
    public ArrayList<Question> makeRequestOfReceivingQuestions() {
        ArrayList<String> aString = new ArrayList<>();
        aString.add("Question");
        Request request = createNewRequest(aString, "all", "GET");
        ArrayList answer = getAnswerNewRequest(request, "Question");
        return answer;
    }

    public ArrayList<GivenAnswer> makeRequestWithGivenAnswer(ArrayList<GivenAnswer> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "GivenAnswer");
        if (answer.size() > 1) {
            return answer;
        }
        return null;
    }

    public ArrayList<Result> makeRequestOfResults(ArrayList<Result> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Result");
        if (answer.size() > 1) {
            return answer;
        }
        return null;
    }

    public ArrayList<Route> makeRequestWithRoute(ArrayList<Route> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Route");
        if (answer.size() > 1) {
            return answer;
        }
        return null;
    }

    public ArrayList<Grant> makeRequestWithGrant(ArrayList<Grant> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Grant");
        if (answer.size() > 1) {
            return answer;
        }
        return null;
    }

    public ArrayList<Category> makeRequestWithCategory(ArrayList<Category> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Category");
        if (answer.size() > 1) {
            return answer;

        }
        return null;
    }


    private ArrayList getAnswerNewRequest(Request request, String className) {
//        JsonElement jsonRequest = convertToNewData(request);
        JsonArray receivedRequest = reformToSendRequest(request, className);
        if (request.getDuty().equals("GET")) {
            return decryptReceivedRequest(receivedRequest, className);
        } else {
            return new ArrayList<>();
        }
    }

    private Request createNewRequest(ArrayList variables, String specific, String duty) {
        return new Request(duty, specific, variables, false);
    }

    private ArrayList decryptReceivedRequest(JsonArray receiveRequest, String className) {
        return deconstructionService.deConstructJSON(receiveRequest, className);
    }

    private JsonArray reformToSendRequest(Request request, String className) {
        return reformRequestController.readyToSendRequest(request, className);
    }

    public JsonElement convertToNewData(Request request) {
        return constructionService.constructJSON(request);
    }
}
