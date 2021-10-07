package controllers;

import models.Answer;

public class AnswerController implements Controller {
    Answer answer = new Answer();

    public void startTimer() {
        answer.setStartTime(System.currentTimeMillis());
    }

    public void endTimer() {
        answer.setTotalQuestionTime(System.currentTimeMillis()- answer.getStartTime());
    }
    public long getTotalQuestionTime(){
       return answer.getTotalQuestionTime();
    }
    public long getTotalQuestionTimeSeconds(){
        return answer.getTotalQuestionTime()/1000;
    }
}
