package controllers;

import com.google.gson.JsonElement;
import com.itextpdf.awt.geom.misc.HashCode;
import models.*;
import services.*;
import services.ConstructionService;

import java.util.ArrayList;

public class RequestController implements Controller {
    private final ControllerRegistry controllerRegistry = ControllerRegistry.getInstance();

    private final ReformRequestController reformRequestController = ReformRequestController.getInstance();
    private final ConstructionService constructionService = ConstructionService.getInstance();
    private final DeconstructionService deconstructionService = DeconstructionService.getInstance();

    public ArrayList<Question> makeRequestOfReceivingQuestions() {
        Request request = createNewRequest(null, "GetAllQuestions");
        ArrayList answer = getAnswerNewRequest(request, "Question");
        ArrayList<Question> fullQuestionList = (ArrayList<Question>) setCorrectFormatAnswer(answer, "Question");
        return fullQuestionList;
    }

    public ArrayList<Question> makeRequestOfSendingAnswer(ArrayList<GivenAnswer> variables, String duty) { return null;}
    public void makeRequestOfResults(ArrayList<Route> variables, String duty) {
        Request request = createNewRequest(variables, "GET");
        getAnswerNewRequest(request, "Result");

    }

    public ArrayList<Result> makeRequestOfSendingRoute(ArrayList<Route> variables, String duty, String nameClass) {
        Request request = createNewRequest(variables, duty);
        ArrayList<ArrayList> answer = getAnswerNewRequest(request, "Route");
        ArrayList fullQuestionList = setCorrectFormatAnswer(answer,"Route");
        return fullQuestionList;
    }

    private ArrayList setCorrectFormatAnswer(ArrayList<ArrayList> answer, String classType) {
        Class needClass;
        ArrayList<ArrayList> arrayList = new ArrayList<>();
        try {
            needClass = Class.forName(classType);
            ArrayList<ArrayList> formattedList = new ArrayList<>();
            for(ArrayList arrayListWithin : answer){
                formattedList =(ArrayList<ArrayList>) arrayListWithin;
            }
            return  formattedList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  arrayList;
    }

    private ArrayList<ArrayList> getAnswerNewRequest(Request request, String className) {
        JsonElement jsonRequest = convertToNewData(request);
        HashCode receiveRequest = reformToSendRequest(jsonRequest, className );
        ArrayList<ArrayList> requestAnswer = decryptReceivedRequest(receiveRequest);
        return requestAnswer;
    }

    private Request createNewRequest(ArrayList variables, String duty) {
        return new Request(duty, variables, false);
    }

    private ArrayList<ArrayList> decryptReceivedRequest(HashCode receiveRequest) {
        return deconstructionService.deConstructJSON(receiveRequest);
    }

    private HashCode reformToSendRequest(JsonElement request, String className) {
        return reformRequestController.reformSendRequest(request, className);
    }

    public JsonElement convertToNewData(Request request) {
        return constructionService.constructJSON(request);
    }
}
