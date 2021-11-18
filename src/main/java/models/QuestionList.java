package models;

import java.util.ArrayList;

public  class QuestionList {
    private static ArrayList<Question> questions = new ArrayList<>();
    private static ArrayList<Question> remainingQuestions = new ArrayList<>();

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public ArrayList<Question> getRemainingQuestions() {
        return remainingQuestions;
    }
    public void appendQuestion(Question question){
        questions.add(question);
        remainingQuestions.add(question);
    }
    public void removeRemainingQuestion(Question question){
        remainingQuestions.remove(question);
    }
}
