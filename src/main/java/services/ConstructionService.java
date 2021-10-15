package services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import models.Request;

import java.util.HashMap;

public class ConstructionService {

    static ConstructionService constructionService;

    public static ConstructionService getInstance(){
        if (constructionService == null){
            constructionService = new ConstructionService();
        }
        return constructionService;
    }

    public JsonElement constructJSON(Request request){


        JsonElement jsonElement = new JsonArray();
        return jsonElement;
    }
}
