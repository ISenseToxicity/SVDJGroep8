package models;

import java.util.ArrayList;

public class Request {

    //    Attributes
    private final int userNr = 1;
    private String duty;
    private String specific;
    private ArrayList givenVariables;
    private boolean isNewData ;

//    Constructor


    public Request(String duty, String specific, ArrayList givenVariables, boolean isNewData) {
        this.duty = duty;
        this.specific = specific;
        this.givenVariables = givenVariables;
        this.isNewData = isNewData;
    }




//    Setters And Getters

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public int getUserNr() {
        return userNr;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public ArrayList getGivenVariables() {
        return givenVariables;
    }

    public void setGivenVariables(ArrayList givenVariables) {
        this.givenVariables = givenVariables;
    }

    public boolean isNewData() {
        return isNewData;
    }

    public void setNewData(boolean newData) {
        isNewData = newData;
    }

}
