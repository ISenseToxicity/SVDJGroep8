package controllers;

import models.Answer;

import java.util.ArrayList;

public class QuestionController implements Controller {

    public String getQuestionTitle(int questionNumber){
        QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
        questionListController.getQuestionListFromAPI();
        return questionListController.getQuestions().get(questionNumber).getQuestionText();
    }
    public String getAnswerTitle(int questionNumber, int answerNumber){
        QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
        questionListController.getQuestionListFromAPI();
        return questionListController.getQuestions().get(questionNumber).getAnswers().get(answerNumber).getAnswerText();
    }
    public ArrayList<Answer> getAnswers(int questionNumber){
        QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
       return questionListController.getQuestions().get(questionNumber).getAnswers();
    }
    public String getExtraInfoDescription(int questionNumber){
        QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
        return questionListController.getQuestions().get(questionNumber).getExtraInfoDescription();
    }
}
