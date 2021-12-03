package models;

import java.util.ArrayList;

public class Route {

    private int totalTime;
    private ArrayList<GivenAnswer> givenAnswerList;
    private final Result resultID;

    public Route(int totalTime, Result resultID) {
        this.totalTime = totalTime;
        this.resultID = resultID;
        this.givenAnswerList = new ArrayList<>();
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void setGivenAnswerList(ArrayList<GivenAnswer> givenAnswerList) {
        this.givenAnswerList = givenAnswerList;
    }

    public Result getResultID() {
        return this.resultID;
    }

    public void addGivenAnswer(GivenAnswer givenAnswer) {
        this.givenAnswerList.add(givenAnswer);
    }

    public void removeLastGivenAnswer() {
        this.givenAnswerList.remove(this.givenAnswerList.size() - 1);
    }

    @Override
    public String toString() {
        return "{" +
                "\"result\": \"" + this.resultID.toString() + "\"," +
                "\"givenAnswerList\": \"" + this.givenAnswerList + "\"," +
                "\"totalTime\": \"" + this.totalTime + "\"," +
                "\"routeID\": \"" + this.totalTime + "\"" +
                '}';
    }
}
