package models;

public class GivenAnswer {
    private String givenAnswerID;
    private int elapsedSeconds;
    private String questionID;
    private String answerID;

    public GivenAnswer(String givenAnswerID, int elapsedSeconds, String questionID, String answerID) {
        this.givenAnswerID = givenAnswerID;
        this.elapsedSeconds = elapsedSeconds;
        this.questionID = questionID;
        this.answerID = answerID;
    }

    public String getGivenAnswerID() {
        return this.givenAnswerID;
    }

    public void setGivenAnswerID(String givenAnswerID) {
        this.givenAnswerID = givenAnswerID;
    }

    public int getElapsedSeconds() {
        return this.elapsedSeconds;
    }

    public void setElapsedSeconds(int elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
    }

    public String getQuestionID() {
        return this.questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswerID() {
        return this.answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }
}
