package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Request implements Model{

    //    Attributes
    private final int userNr = 1;
    private String duty;
    private HashMap<String, ArrayList<Model>> givenVariables;
    private boolean isNewData ;

//    Constructor

    public Request(String duty, HashMap<String, ArrayList<Model>> givenVariables, boolean isNewData) {
        this.duty = duty;
        this.givenVariables = givenVariables;
        this.isNewData = isNewData;
    }


//    Setters And Getters

    public int getUserNr() {
        return userNr;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public HashMap<String, ArrayList<Model>> getGivenVariables() {
        return givenVariables;
    }

    public void setGivenVariables(HashMap<String, ArrayList<Model>> givenVariables) {
        this.givenVariables = givenVariables;
    }

    public boolean isNewData() {
        return isNewData;
    }

    public void setNewData(boolean newData) {
        isNewData = newData;
    }
}
