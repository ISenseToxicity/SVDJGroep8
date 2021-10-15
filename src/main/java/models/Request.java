package models;

import java.util.HashMap;

public class Request {

    //    Attributes
    private final int userNr = 1;
    private String duty;
    private HashMap<String,String> givenVariables;
    private boolean isNewData ;

//    Constructor

    public Request(String duty, HashMap<String,String> givenVariables, boolean isNewData) {
        this.duty = duty;
        this.givenVariables = givenVariables;
        this.isNewData = isNewData;
    }


//    Setters And Gettes

    public int getUserNr() {
        return userNr;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public HashMap<String,String> getGivenVariables() {
        return givenVariables;
    }

    public void setGivenVariables(HashMap<String,String> givenVariables) {
        this.givenVariables = givenVariables;
    }

    public boolean isNewData() {
        return isNewData;
    }

    public void setNewData(boolean newData) {
        isNewData = newData;
    }
}
