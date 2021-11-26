package models;

import java.util.ArrayList;

public class Answer {
    private String answerID;
    private String answerText;
    private ArrayList<String> categoryID;

    public Answer(String answerID, String answerText, ArrayList<String> categoryID) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.categoryID = categoryID;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public ArrayList<String> getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(ArrayList<String> categoryID) {
        this.categoryID = categoryID;
    }
}
