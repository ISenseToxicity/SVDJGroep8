package controllers;


import models.Question;
import models.QuestionList;

import java.util.ArrayList;

public class QuestionListController implements Controller {
    private QuestionList questionList = new QuestionList();

    public void getQuestionListFromAPI(){
        //todo get QuestionList from the DAO
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
