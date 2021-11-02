package controllers;
import models.GivenAnswer;

public class GivenAnswerController implements Controller {

    public GivenAnswerController() {}

    public GivenAnswer addGivenAnswer(String givenAnswerID, int elapsedSeconds, String questionID, String answerID ) {
        GivenAnswer givenAnswer = new GivenAnswer(givenAnswerID,elapsedSeconds,questionID,answerID);
        return givenAnswer;
    }

}
