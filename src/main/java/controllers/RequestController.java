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

        return !getAnswerNewRequest(request, "grant").isEmpty();
    }

    /**
     * Make Requests to de Database
     *
     * @return Wanted database models
     * @author Eefje | AntiEevee
     */
    public ArrayList<Question> makeRequestOfReceivingQuestions() {
        ArrayList<String> aString = new ArrayList<>();
        aString.add("Question");
        Request request = createNewRequest(aString, "all", "GetAllQuestions");
        ArrayList answer = getAnswerNewRequest(request, "Question");
        return (ArrayList<Question>) setCorrectFormatAnswer(answer, "Question");
    }

    public ArrayList<GivenAnswer> makeRequestWithGivenAnswer(ArrayList<GivenAnswer> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "GivenAnswer");
        if (answer.size() > 1) {
            return (ArrayList<GivenAnswer>) setCorrectFormatAnswer(answer, "Question");
        }
        return null;
    }

    public ArrayList<Result> makeRequestOfResults(ArrayList<Result> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Result");
        if (answer.size() > 1) {
            return (ArrayList<Result>) setCorrectFormatAnswer(answer, "Result");

        }
        return null;
    }

    public ArrayList<Route> makeRequestWithRoute(ArrayList<Route> variables, String specific, String duty) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Route");
        if (answer.size() > 1) {
            return (ArrayList<Route>) setCorrectFormatAnswer(answer, "Route");

        }
        return null;
    }

    public ArrayList<Grant> makeRequestWithGrant(ArrayList<Grant> variables, String specific, String duty, String nameClass) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Grant");
        if (answer.size() > 1) {
            return (ArrayList<Grant>) setCorrectFormatAnswer(answer, "Grant");

        }
        return null;
    }

    public ArrayList<Category> makeRequestWithCategory(ArrayList<Category> variables, String specific, String duty, String nameClass) {
        Request request = createNewRequest(variables, specific, duty);
        ArrayList answer = getAnswerNewRequest(request, "Category");
        if (answer.size() > 1) {
            return (ArrayList<Category>) setCorrectFormatAnswer(answer, "Category");

        }
        return null;
    }


    /**
     * Find the correct class and from the  inner Array list to the wanted clas
     *
     * @param answer
     * @param classType
     * @return Arraylist 'type'
     */
    private ArrayList setCorrectFormatAnswer(ArrayList<ArrayList> answer, String classType) {
        Class needClass;
        ArrayList<ArrayList> arrayList = new ArrayList<>();
        try {
            needClass = Class.forName(classType);
            ArrayList<ArrayList> formattedList = new ArrayList<>();
            for (ArrayList arrayListWithin : answer) {
                formattedList = (ArrayList<ArrayList>) arrayListWithin;
            }
            return formattedList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    private ArrayList getAnswerNewRequest(Request request, String className) {
//        JsonElement jsonRequest = convertToNewData(request);
        JsonArray receivedRequest = reformToSendRequest(request, className);
        ArrayList requestAnswer = decryptReceivedRequest(receivedRequest, className);
        return requestAnswer;
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
