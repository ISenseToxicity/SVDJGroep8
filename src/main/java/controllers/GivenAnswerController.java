package controllers;
import models.GivenAnswer;

public class GivenAnswerController implements Controller {
    GivenAnswer givenAnswer = new GivenAnswer();

    public void startTimer() {
        givenAnswer.setStartTime(System.currentTimeMillis());
    }

    public void endTimer() {
        givenAnswer.setTotalQuestionTime(System.currentTimeMillis()- givenAnswer.getStartTime());
    }

    public long getTotalQuestionTime(){
        return givenAnswer.getTotalQuestionTime();
    }

    public long getTotalQuestionTimeSeconds(){
        return givenAnswer.getTotalQuestionTime()/1000;
    }
    public String getQuestionID() {
        return givenAnswer.getQuestionID();
    }

    public void setQuestionID(String questionID) {
        givenAnswer.setQuestionID(questionID);
    }

    public String getAnswerID() {
        return givenAnswer.getAnswerID();
    }

    public void setAnswerID(String answerID) {
        givenAnswer.setAnswerID(answerID);
    }
}
