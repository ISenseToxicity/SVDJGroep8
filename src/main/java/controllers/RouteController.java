package controllers;

import models.GivenAnswer;
import models.Route;

import java.util.ArrayList;

public class RouteController implements Controller {

    Route route;
    GivenAnswerController givenAnswerController;

    public RouteController() {
        route = new Route(
                0,
                "placeholder resultID" //TODO: get route ID from DAO
                );
        givenAnswerController = new GivenAnswerController();
    }

    public void setTotalTime(int elapsedSeconds) {
        route.setTotalTime(route.getTotalTime()+elapsedSeconds);
    }

    public int getTotalTime() {
        return route.getTotalTime();
    }

    public void setGivenAnswerList(ArrayList<GivenAnswer> givenAnswerList) {
        route.setGivenAnswerList(givenAnswerList);
    }

    public void addGivenAnswer(String givenAnswerID, int elapsedSeconds, String questionID, String answerID) {
        addGivenAnswerToRoute(givenAnswerController.addGivenAnswer(
                givenAnswerID,
                elapsedSeconds,
                questionID,
                answerID)
        );
        setTotalTime(elapsedSeconds);
    }

    public void addGivenAnswerToRoute(GivenAnswer givenAnswer) {
        route.addGivenAnswer(givenAnswer);
    }

    public void removeLastGivenAnswerFromRoute() {
        route.removeLastGivenAnswer();
    }

    public Route getRoute() {
        return route;
    }

    public String getResultID(){
        return route.getResultID();
    }
}
