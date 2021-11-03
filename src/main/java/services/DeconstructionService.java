package services;

import com.itextpdf.awt.geom.misc.HashCode;
import models.*;

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

    public ArrayList<ArrayList> deConstructJSON(HashCode requestJsonAnswer) {
       ArrayList<ArrayList> array = new ArrayList<>();
        return array;
    }
}
