package models;

public class Answer {
    private long startTime;
    private long totalQuestionTime;
    private String questionID;
    private String answerID;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getTotalQuestionTime() {
        return totalQuestionTime;
    }

    public void setTotalQuestionTime(long totalQuestionTime) {
        this.totalQuestionTime = totalQuestionTime;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }
}
