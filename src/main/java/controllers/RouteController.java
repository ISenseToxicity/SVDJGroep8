package controllers;

import com.google.gson.Gson;
import daos.RouteDAO;
import models.*;

import java.util.ArrayList;

public class RouteController implements Controller {

    private Route route;
    private GivenAnswerController givenAnswerController;
    private RouteDAO dao;

    public RouteController() {
        route = new Route(
                0,
                new Result() //TODO: get resultID from DAO
                );
        givenAnswerController = new GivenAnswerController();
        dao = RouteDAO.getInstance();
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

    public void addGivenAnswer(String givenAnswerID, int elapsedSeconds, Question questionID, Answer answerID) {
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

    public Result getResultID(){
        return route.getResultID();
    }

    public void postRoute() {
        String json = new Gson().toJson(route);
        dao.post(json);
    }
}
