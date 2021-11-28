package models;

import java.util.ArrayList;

public class Question {
    private String questionID;
    private String questionText;
    private ArrayList<Answer> answers;
    private String extraInfoTile;
    private String extraInfoDescription;
    private String extraInfoVideoURL;

    public Question(String questionID, String questionText, ArrayList<Answer> answers, String extraInfoTile, String extraInfoDescription, String extraInfoVideoURL) {
        this.questionID = questionID;
        this.questionText = questionText;
        this.answers = answers;
        this.extraInfoTile = extraInfoTile;
        this.extraInfoDescription = extraInfoDescription;
        this.extraInfoVideoURL = extraInfoVideoURL;
    }

    public Question(String questionID, String questionText, ArrayList<Answer> answers, String extraInfoTile, String extraInfoDescription) {
        this.questionID = questionID;
        this.questionText = questionText;
        this.answers = answers;
        this.extraInfoTile = extraInfoTile;
        this.extraInfoDescription = extraInfoDescription;
    }


    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public String getExtraInfoTile() {
        return extraInfoTile;
    }

    public void setExtraInfoTile(String extraInfoTile) {
        this.extraInfoTile = extraInfoTile;
    }

    public String getExtraInfoDescription() {
        return extraInfoDescription;
    }

    public void setExtraInfoDescription(String extraInfoDescription) {
        this.extraInfoDescription = extraInfoDescription;
    }

    public String getExtraInfoVideoURL() {
        return extraInfoVideoURL;
    }

    public void setExtraInfoVideoURL(String extraInfoVideoURL) {
        this.extraInfoVideoURL = extraInfoVideoURL;
    }

    @Override
    public String toString() {
        StringBuilder answerI = null;
        for(Answer answer : answers) {
            answerI.append(answer.toString()).append(",");
        }
        return "{" +
                "answers: [" + answerI +
                "], extraInfoTile: \"" + extraInfoTile + "\"," +
                "extraInfoDescription: \"" + extraInfoDescription + "\"," +
                "extraInfoVideoURL: \"" + extraInfoVideoURL + "\"," +
                "questionID: " + questionID + "," +
                "questionText: \"" + questionText + "\"," +
                '}';
    }
}