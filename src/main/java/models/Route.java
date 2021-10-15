package models;

import java.util.ArrayList;

public class Route {

    private int totalTime;
    private ArrayList<GivenAnswer> givenAnswerList;
    private String resultID;

    public Route(int totalTime, String resultID) {
        this.totalTime = totalTime;
        this.resultID = resultID;
        givenAnswerList = new ArrayList<GivenAnswer>();
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public ArrayList<GivenAnswer> getGivenAnswerList() {
        return givenAnswerList;
    }

    public void setGivenAnswerList(ArrayList<GivenAnswer> givenAnswerList) {
        this.givenAnswerList = givenAnswerList;
    }

    public String getResultID() {
        return resultID;
    }

    public void setResultID(String resultID) {
        this.resultID = resultID;
    }

    public void addGivenAnswer(GivenAnswer givenAnswer) {
        givenAnswerList.add(givenAnswer);
    }
}
