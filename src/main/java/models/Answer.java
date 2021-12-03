package models;

import java.util.ArrayList;

public class Answer {
    private String answerID;
    private String answerText;
    private ArrayList<Category> categoryID;

    public Answer(String answerID, String answerText, ArrayList<Category> categoryID) {
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

    public ArrayList<Category> getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(ArrayList<Category> categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        StringBuilder category = null;
        for(Category cat : categoryID) {
            category.append(cat.toString()).append(",");
        }
        return "{" +
                "\"answerID\": \"" + categoryID + "\"," +
                "\"answerText\": \"" + answerText + "\"," +
                "\"category\": "+ category +"\","+
                "\"questionID\": \"" + categoryID +'\"' +
                '}';
    }
}
