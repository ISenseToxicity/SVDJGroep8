package controllers;


import daos.QuestionListDAO;
import models.ExceptionReturnObject;
import models.Question;
import models.QuestionList;

import java.util.ArrayList;

public class QuestionListController implements Controller {
    private QuestionList questionList;
    private final QuestionListDAO questionListDAO = new QuestionListDAO();

    public void getQuestionListFromAPI(){
        try{
            Object[] objects = questionListDAO.getQuestionList();
            if(checkIfExceptionReturnObjectIsNull((ExceptionReturnObject) objects[0])){
                this.questionList =(QuestionList) objects[1];
            }else{
                //todo handle Exception
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkIfExceptionReturnObjectIsNull(ExceptionReturnObject exceptionReturnObject){

        if(exceptionReturnObject.getApplicationInfo() == null){
            if(exceptionReturnObject.getHttpStatus() == null){
                return exceptionReturnObject.getUserMessage() == null;
            }
        }
        return false;
    }

    public ArrayList<Question> getQuestions() {
        return questionList.getQuestions();
    }
}
