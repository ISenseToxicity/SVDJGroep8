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
            return;
        }
        ArrayList<Category> activeCategories = categoryListController.getActiveCategories();
        for (Question question: questions) {
            for(Answer answer : question.getAnswers()) {
                for (String category : answer.getCategoryID()) {
                    for (Category activeCategory: activeCategories) {
                        if (category.equals(activeCategory.getId())) {
                            questionOrder.setCurrentQuestion(question);
                        }
                    }
                }
            }
        }
    }

    public Question getCurrentQuestion() {
        return questionOrder.getCurrentQuestion();
    }
}



