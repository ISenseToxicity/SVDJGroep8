package controllers;

import models.Grant;

import java.util.ArrayList;

public class GrantController implements Controller {

    ArrayList<Grant> grantList = new ArrayList<>();

    public void getAllGrantsFromAPI() {
        // TODO: zorg dat ie alles uit de API krijgt.
    }

    public ArrayList<Grant> getAllGrants() {
        return grantList;
    }

}
