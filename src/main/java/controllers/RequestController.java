package controllers;

import com.google.gson.JsonElement;
import com.itextpdf.awt.geom.misc.HashCode;
import models.Model;
import models.Question;
import models.Request;
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
        ArrayList<ArrayList> answer = getAnswerNewRequest(request);
        ArrayList<Question> fullQuestionList = (ArrayList<Question>) setCorrectFormatAnswer(answer, "Question");
        return fullQuestionList;
    }

    public ArrayList<Question> makeRequestOfSendingAnswer() { return null;}
    public ArrayList<Question> makeRequestOfQuestions(ArrayList<Question> questions) {return null;}

    public ArrayList makeRequestOfSending(ArrayList<Model> variables, String duty,String nameClass) {
        Request request = createNewRequest(variables, duty);
        ArrayList<ArrayList> answer = getAnswerNewRequest(request);
        ArrayList fullQuestionList = setCorrectFormatAnswer(answer, nameClass);
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

    private ArrayList<ArrayList> getAnswerNewRequest(Request request) {
        JsonElement jsonRequest = convertToNewData(request);
        HashCode receiveRequest = reformToSendRequest(jsonRequest);
        ArrayList<ArrayList> requestAnswer = decryptReceivedRequest(receiveRequest);
        return requestAnswer;
    }

    private Request createNewRequest(ArrayList variables, String duty) {
        return new Request(duty, variables, false);
    }

    private ArrayList<ArrayList> decryptReceivedRequest(HashCode receiveRequest) {
        return deconstructionService.deConstructJSON(receiveRequest);
    }

    private HashCode reformToSendRequest(JsonElement request) {
        return reformRequestController.reformSendRequest(request);
    }

    public JsonElement convertToNewData(Request request) {
        return constructionService.constructJSON(request);
    }
}
