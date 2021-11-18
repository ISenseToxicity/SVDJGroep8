package controllers;

import models.Answer;

import java.util.ArrayList;

public class QuestionController implements Controller {
    QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);

    public String getQuestionTitle(int questionNumber){
        return questionListController.getRemainingQuestions().get(questionNumber).getQuestionText();
    }
    public String getAnswerTitle(int questionNumber, int answerNumber){
        return questionListController.getRemainingQuestions().get(questionNumber).getAnswers().get(answerNumber).getAnswerText();
    }
    public ArrayList<Answer> getAnswers(int questionNumber){
       return questionListController.getRemainingQuestions().get(questionNumber).getAnswers();
    }

    public String getExtraInfoDescription(int questionNumber){
        return questionListController.getRemainingQuestions().get(questionNumber).getExtraInfoDescription();
    }
}
