package models;

import java.util.ArrayList;

public class Answer {
    private String answerID;
    private String answerText;
    private ArrayList<Category> categories;

    public Answer(String answerID, String answerText, ArrayList<Category> categoryID) {
        this.answerID = answerID;
        this.answerText = answerText;
        this.categories = categoryID;
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

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        StringBuilder category = new StringBuilder();
        for(Category cat : categories) {
            category.append(cat.toString()).append(",");
        }

        return "{" +
                "\"answerID\": \"" + answerID + "\"," +
                "\"answerText\": \"" + answerText + "\"," +
                "\"category\": "+ category +"\""+
                '}';
    }
}
