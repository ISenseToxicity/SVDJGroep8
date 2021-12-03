package controllers;
import models.Answer;
import models.GivenAnswer;
import models.Question;

public class GivenAnswerController implements Controller {

    public GivenAnswerController() {}

    public GivenAnswer addGivenAnswer(String givenAnswerID, int elapsedSeconds, Question questionID, Answer answerID ) {
        GivenAnswer givenAnswer = new GivenAnswer(givenAnswerID,elapsedSeconds,questionID,answerID);
        return givenAnswer;
    }

}
