package controllers;


import daos.QuestionListDAO;
import models.Question;
import models.QuestionList;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionListController implements Controller {
    private QuestionList questionList;
    private final QuestionListDAO questionListDAO = new QuestionListDAO();

    public void getQuestionListFromAPI(){
        try {
            this.questionList = questionListDAO.getQuestionList();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Question> getQuestions() {
        return questionList.getQuestions();
    }
}
