package models;

public class GivenAnswer {
    private String givenAnswerID;
    private int elapsedSeconds;
    private Question question;
    private Answer answer;
    private Route routeID;

    public GivenAnswer(String givenAnswerID, int elapsedSeconds, Question questionID, Answer answerID) {
        this.givenAnswerID = givenAnswerID;
        this.elapsedSeconds = elapsedSeconds;
        this.question = questionID;
        this.answer = answerID;
    }

    public Route getRouteID() {
        return routeID;
    }

    public void setRouteID(Route routeID) {
        this.routeID = routeID;
    }

    public String getGivenAnswerID() {
        return givenAnswerID;
    }

    public void setGivenAnswerID(String givenAnswerID) {
        this.givenAnswerID = givenAnswerID;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getElapsedSeconds() {
        return this.elapsedSeconds;
    }

    public void setElapsedSeconds(int elapsedSeconds) {
        this.elapsedSeconds = elapsedSeconds;
    }

    @Override
    public String toString() {
        return "{" +
                "answer: " + this.answer.toString() + "\"," +
                "elapsedSeconds: \"" + this.elapsedSeconds + "\"," +
                "question: " + this.question.toString() + "\"," +
                "route: " + this.routeID.toString() +
                '}';
    }
}
