package controllers;


import daos.QuestionListDAO;
import models.Question;
import models.QuestionList;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionListController implements Controller {
    private QuestionList questionList = new QuestionList();

    public void getQuestionListFromAPI(){
        QuestionListDAO questionListDAO = new QuestionListDAO();

        try {
            if(questionListDAO.getQuestionList() == 200){
                //todo handle exeption
            }

        }
        catch (IOException ioException){
           ioException.getMessage();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Question> getQuestions() {
        return questionList.getQuestions();
    }
    public void appendQuestion(Question question){
        questionList.appendQuestion(question);
    }
}
