package controllers;

import models.GeneralException;

public class ExceptionController implements Controller {
    private GeneralException generalException;

    public void throwGeneralException(GeneralException generalException){
        this.generalException = generalException;
        throw new RuntimeException(new Exceptions.GeneralException());
    }

    public Integer getStatus() {
        return generalException.getStatus();
    }

    public String getPath() {
        return generalException.getPath();
    }

    public String getErrorMessage() {
        return generalException.getErrorMessage();
    }

    public String getTimeStamp() {
        return generalException.getTimeStamp();
    }

    public String getTrace() {
        return generalException.getTrace();
    }
}
