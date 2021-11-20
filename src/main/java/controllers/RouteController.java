package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import daos.RouteDAO;
import models.GivenAnswer;
import models.Route;

import java.io.IOException;
import java.util.ArrayList;

public class RouteController implements Controller {

    private Route route;
    private GivenAnswerController givenAnswerController;
    private RouteDAO dao;

    public RouteController() {
        route = new Route(
                0,
                "placeholder resultID" //TODO: get resultID from DAO: DAO.getNextRouteId???
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

    public void addGivenAnswerToRoute(GivenAnswer givenAnswer) {
        route.addGivenAnswer(givenAnswer);
        route.setTotalTime(route.getTotalTime()+givenAnswer.getElapsedSeconds());
    }

    public void removeLastGivenAnswerFromRoute() {
        route.removeLastGivenAnswer();
    }

    public String getResultID(){
        return route.getResultID();
    }

    public void postRoute() {
        String json = new Gson().toJson(route);
        dao.post(json);
    }
}
