package models;

import java.util.ArrayList;

public class Question {
    private ArrayList<String> questionID;
    private ArrayList<String> questionText;

    public ArrayList<String> getQuestionID() {
        return questionID;
    }

    public void setQuestionID(ArrayList<String> questionID) {
        this.questionID = questionID;
    }

    public ArrayList<String> getQuestionText() {
        return questionText;
    }

    public void setQuestionText(ArrayList<String> questionText) {
        this.questionText = questionText;
    }
}
