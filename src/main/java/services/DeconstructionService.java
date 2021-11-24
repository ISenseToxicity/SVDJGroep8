package services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import models.*;
import org.junit.Assert;

import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class DeconstructionService {

    private static DeconstructionService deconstructionService;

    public static DeconstructionService getInstance() {
        if (deconstructionService == null) {
            deconstructionService = new DeconstructionService();
        }
        return deconstructionService;
    }

    public ArrayList deConstructJSON(JsonArray requestJsonAnswer, String className) {
        ArrayList a = new ArrayList<>();
        for (JsonElement item : requestJsonAnswer) {
//            a.add((className.getClass()) new Gson().fromJson(item, className.getClass()));
            a.add(setToCorerrectModel(className, item));
        }
        return a;
    }

    private Object setToCorerrectModel(String className, JsonElement item) {
        Object o = null;
        switch (className.toLowerCase()) {
            case "grant" -> o = getGrant(item);
            case "question" -> o = getQuestion(item);
            case "answer" -> o = getAnswer(item);
            case "givenanswer" -> o = getGivenAnswer(item);
            case "route" -> o = getRoute(item);
            case "result" -> o = getResult(item);
            case "category" -> o = getCatogory(item);
        }
        return o;
    }

    private GivenAnswer getGivenAnswer(JsonElement item) {
        return (GivenAnswer) new Gson().fromJson(item, GivenAnswer.class);
    }

    private Grant getGrant(JsonElement item) {
        return (Grant) new Gson().fromJson(item, Grant.class);
    }

    private Question getQuestion(JsonElement item) {
        return (Question) new Gson().fromJson(item, Question.class);
    }

    private Category getCatogory(JsonElement item) {
        return (Category) new Gson().fromJson(item, Category.class);
    }

    private Answer getAnswer(JsonElement item) {
        return (Answer) new Gson().fromJson(item, Answer.class);
    }

    private Route getRoute(JsonElement item) {
        return (Route) new Gson().fromJson(item, Route.class);
    }

    private Result getResult(JsonElement item) {
        return (Result) new Gson().fromJson(item, Result.class);
    }


}
