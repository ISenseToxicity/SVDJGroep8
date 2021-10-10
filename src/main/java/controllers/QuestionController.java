package controllers;

import models.Question;

import java.util.ArrayList;

public class QuestionController implements Controller {
    Question question = new Question();

    public ArrayList<String> getQuestionID() {
        return question.getQuestionID();
    }

    public void setQuestionID(ArrayList<String> questionID) {
        question.setQuestionID(questionID);
    }

    public ArrayList<String> getQuestionText() {
        return question.getQuestionID();
    }

    public void setQuestionText(ArrayList<String> questionText) {
        question.setQuestionText(questionText);
    }

    public String getSpecificQuestionID(int id){
        return question.getQuestionID().get(id);
    }

    public String getSpecificQuestionText(int id){
        return question.getQuestionText().get(id);
    }
}
