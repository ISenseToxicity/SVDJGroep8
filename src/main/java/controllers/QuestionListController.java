package controllers;


import daos.QuestionListDAO;
import models.ExceptionReturnObject;
import models.Question;
import models.QuestionList;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionListController implements Controller {
    private QuestionList questionList;
    private final QuestionListDAO questionListDAO = new QuestionListDAO();

    public void getQuestionListFromAPI(){
        try{
            Object object = questionListDAO.getQuestionList();

            if(object instanceof QuestionList){
                this.questionList = (QuestionList) object;
            }
            if(object instanceof ExceptionReturnObject){
                //todo handle exeption
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public ArrayList<Question> getQuestions() {
        return questionList.getQuestions();
    }
}
