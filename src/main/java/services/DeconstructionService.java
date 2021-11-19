package services;

import com.google.gson.JsonElement;

import java.util.ArrayList;

public class DeconstructionService {

    private static DeconstructionService deconstructionService;

    public static DeconstructionService getInstance() {
        if (deconstructionService == null) {
            deconstructionService = new DeconstructionService();
        }
        return deconstructionService;
    }

    public ArrayList<ArrayList> deConstructJSON(JsonElement requestJsonAnswer) {
       ArrayList<ArrayList> array = new ArrayList<>();
        return array;
    }
}
