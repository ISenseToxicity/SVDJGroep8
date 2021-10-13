package controllers;

import models.Answer;
import models.Question;

import java.util.ArrayList;

public class QuestionController implements Controller {

    public Question makeQuestion(String questionID, String questionText, ArrayList<Answer> answers, String extraInfoTile, String extraInfoDescription, String extraInfoVideoURL){

       return new Question(questionID, questionText, answers, extraInfoTile, extraInfoDescription, extraInfoVideoURL);
    }
    public Question makeQuestion(String questionID, String questionText, ArrayList<Answer> answers, String extraInfoTile, String extraInfoDescription){
        return new Question(questionID, questionText, answers, extraInfoTile, extraInfoDescription);
    }
}
