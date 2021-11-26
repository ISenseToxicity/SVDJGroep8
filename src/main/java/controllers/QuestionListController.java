package controllers;


import daos.QuestionListDAO;
import models.Question;
import models.QuestionList;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionListController implements Controller {
    private QuestionList questionList = new QuestionList();
    private final RequestController requestController =(RequestController) ControllerRegistry.get(RequestController.class);

    public void getQuestionListFromAPI(){
        ArrayList<Question>  ArrayQuestions = requestController.makeRequestOfReceivingQuestions();
        for(Question question: ArrayQuestions){
            questionList.appendQuestion(question);
        }
    }
    public ArrayList<Question> getQuestions() {
        return questionList.getQuestions();
    }
    public void appendQuestion(Question question){
        questionList.appendQuestion(question);
    }

    public ArrayList<Question> getRemainingQuestions() {
        return questionList.getRemainingQuestions();
    }
    public void removeRemainingQuestion(Question question){
        questionList.removeRemainingQuestion(question);
    }
}
