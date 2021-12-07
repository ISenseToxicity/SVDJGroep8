package controllers;

import models.Answer;
import models.Category;
import models.Question;
import models.QuestionOrder;

import java.util.ArrayList;

public class QuestionOrderController implements Controller {
    QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
    CategoryListController categoryListController = (CategoryListController) ControllerRegistry.get(CategoryListController.class);
    QuestionOrder questionOrder = new QuestionOrder();

    public void calculateNextQuestion() {
        questionListController.removeRemainingQuestion(questionOrder.getCurrentQuestion());
        ArrayList<Question> questions = questionListController.getRemainingQuestions();
        if (questions.isEmpty()) {
            //TODO: should reroute to result screen right?
            return;
        }

        questionOrder.setCurrentQuestion(questions.get(0));
    }

    public Question getCurrentQuestion() {
        return questionOrder.getCurrentQuestion();
    }
}



