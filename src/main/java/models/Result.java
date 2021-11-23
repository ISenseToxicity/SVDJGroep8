package models;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Result {
    private Long resultID;


    private int amountQuestions;

    private Time totalTime;
    private Grant grant;

    public Result(Long resultID, int amountQuestions, Time totalTime) {
        this.resultID = resultID;
        this.amountQuestions = amountQuestions;
        this.totalTime = totalTime;
    }

    public Result(Long resultID, int amountQuestions, String totalTime) throws ParseException {
        this.resultID = resultID;
        this.amountQuestions = amountQuestions;
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        this.totalTime = (Time) formatter.parse(totalTime);

    }

    public Result() {

    }


    public void setResultID(Long resultID) {
        this.resultID = resultID;
    }

    public Long getResultID() {
        return resultID;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public void setAmountQuestions(int amountQuestions) {
        this.amountQuestions = amountQuestions;
    }

    public Time getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Time totalTime) {
        this.totalTime = totalTime;
    }

    public Grant getGrant() {
        return grant;
    }
}
