package controllers;

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
                "placeholder resultID" //TODO: get resultID from DAO
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

    public String getResultID(){
        return route.getResultID();
    }

    public void post() throws IOException, InterruptedException {
        //TODO: should call Jsonbuilder class or something also below code sucks
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("routeid",route.getResultID());
        jsonObject.addProperty("time",route.getTotalTime());

        JsonObject givenAnswerJson = new JsonObject();
        for (GivenAnswer givenAnswer : route.getGivenAnswerList()) {
            givenAnswerJson.addProperty("given_answer_id", givenAnswer.getGivenAnswerID());
            givenAnswerJson.addProperty("elapsed_seconds", givenAnswer.getElapsedSeconds());
            givenAnswerJson.addProperty("question_id", givenAnswer.getQuestionID());
            givenAnswerJson.addProperty("answer_id", givenAnswer.getAnswerID());
        }

        jsonObject.add("given_answers", givenAnswerJson);

        dao.post(jsonObject.toString());
    }
}
