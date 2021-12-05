package models;

import java.util.ArrayList;

public class Answer {
    private String answerID;
    private String answerText;
    private ArrayList<Category> category;

    public Answer(String answerID, String answerText, ArrayList<Category> category) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.category = category;
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

    public ArrayList<Category> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder category = new StringBuilder();
        for(Category cat : this.category) {
            category.append(cat.toString()).append(",");
        }

        return "{" +
                "\"answerID\": \"" + answerID + "\"," +
                "\"answerText\": \"" + answerText + "\"," +
                "\"category\": "+ category +"\""+
                '}';
    }
}
