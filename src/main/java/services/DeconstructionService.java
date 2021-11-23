package services;

import com.google.gson.JsonArray;

import java.util.ArrayList;

public class DeconstructionService {

    private static DeconstructionService deconstructionService;

    public static DeconstructionService getInstance() {
        if (deconstructionService == null) {
            deconstructionService = new DeconstructionService();
        }
        return deconstructionService;
    }

    public ArrayList deConstructJSON(JsonArray requestJsonAnswer, String className) {
//        requestJsonAnswer
       ArrayList array = new ArrayList<>();
        return array;
    }
}
