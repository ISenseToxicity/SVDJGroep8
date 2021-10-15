package services;

import com.google.gson.JsonElement;
import models.Request;

import java.util.HashMap;
import java.util.Map;

public class DeconstructionService {

    static DeconstructionService deconstructionService;

    public static DeconstructionService getInstance() {
        if (deconstructionService == null) {
            deconstructionService = new DeconstructionService();
        }
        return deconstructionService;
    }

    public HashMap<String, String> deConstructJSON(JsonElement requestJsonAnswer) {

        HashMap<String, String> map = new HashMap<>();
        return map;
    }
}
