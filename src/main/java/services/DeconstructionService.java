package services;

import com.itextpdf.awt.geom.misc.HashCode;
import models.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class DeconstructionService {

    private static DeconstructionService deconstructionService;

    public static DeconstructionService getInstance() {
        if (deconstructionService == null) {
            deconstructionService = new DeconstructionService();
        }
        return deconstructionService;
    }

    public HashMap<String, ArrayList<Model>> deConstructJSON(HashCode requestJsonAnswer) {
        HashMap<String, ArrayList<Model>> map = new HashMap<>();
        return map;
    }
}
