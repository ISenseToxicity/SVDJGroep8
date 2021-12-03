package daos;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import controllers.ControllerRegistry;
import controllers.QuestionListController;
import models.Answer;
import models.Category;
import models.Question;
import models.ReturnModel;
import services.GetService;
import java.io.IOException;
import java.util.ArrayList;


public class QuestionListDAO {
    private final Gson gson = new Gson();
    private final GetService getService =  GetService.getInstance();

    public int getQuestionList() throws IOException {
       String response = getService.getResponse("http://localhost:8080/AllQuestion");
       ReturnModel returnModel = gson.fromJson(response,ReturnModel.class);
        if(returnModel.getHttpStatus()==200){
            makeQuestionList(returnModel);
            return returnModel.getHttpStatus();
        }
        if(returnModel.getHttpStatus()==400){
            makeQuestionList(null);
            return  returnModel.getHttpStatus();
        }
        return returnModel.getHttpStatus();
    }

    private void makeQuestionList(ReturnModel returnModel){
        LinkedTreeMap questionListLinkedTreeMap = (LinkedTreeMap) returnModel.getReturnObject();
        ArrayList arrayList = (ArrayList) questionListLinkedTreeMap.get("questions");
        QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
        for(Object object: arrayList){
            LinkedTreeMap questionLinkedTreeMap = (LinkedTreeMap) object;
            Question question = makeQuestion(questionLinkedTreeMap);
            questionListController.appendQuestion(question);
        }
    }
    private Question makeQuestion(LinkedTreeMap linkedTreeMap){
        if(linkedTreeMap.get("extraInfoVideoURL") == null){
            return new Question(linkedTreeMap.get("questionID").toString(),linkedTreeMap.get("questionText").toString(),makeAnswerArrayList((ArrayList<Answer>) linkedTreeMap.get("answers")), linkedTreeMap.get("extraInfoTile").toString(), linkedTreeMap.get("extraInfoDescription").toString());
        }
        return new Question(linkedTreeMap.get("questionID").toString(),linkedTreeMap.get("questionText").toString(),makeAnswerArrayList((ArrayList<Answer>) linkedTreeMap.get("answers")) ,linkedTreeMap.get("extraInfoTile").toString(), linkedTreeMap.get("extraInfoDescription").toString(),linkedTreeMap.get("extraInfoVideoURL").toString());
    }

private ArrayList<Answer> makeAnswerArrayList(ArrayList answerList){
        ArrayList<Answer> answerArrayList = new ArrayList<>();
    for(Object object : answerList){
        LinkedTreeMap answerLinkedTreeMap = (LinkedTreeMap) object;
        answerArrayList.add(new Answer(answerLinkedTreeMap.get("answerID").toString(), answerLinkedTreeMap.get("answerText").toString(), (ArrayList<Category>) answerLinkedTreeMap.get("categoryID")));
    }
return answerArrayList;
}
}
