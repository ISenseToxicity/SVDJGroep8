package controllers;

import models.Question;
import models.QuestionOrder;

import java.util.ArrayList;

public class QuestionOrderController implements Controller{
QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
QuestionOrder questionOrder = new QuestionOrder();

    public void calculateNextQuestion(){
        questionListController.removeRemainingQuestion(questionOrder.getCurrentQuestion());
        questionListController.getRemainingQuestions();
        ArrayList<Question> questions = questionListController.getRemainingQuestions();
        if(questions.isEmpty()){
            return;
        }
        //todo calculate next questions with Grants
        questionOrder.setCurrentQuestion(questions.get(0));
    }
    public Question getCurrentQuestion(){
        return questionOrder.getCurrentQuestion();
    }
    }



