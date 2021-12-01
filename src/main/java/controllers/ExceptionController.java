package controllers;

import models.Exception;

public class ExceptionController implements Controller {
    Exception exception;
    public void setExceptionResponse(Exception exception){
        this.exception = exception;
    }

    public Integer getStatus() {
        return exception.getStatus();
    }

    public String getPath() {
        return exception.getPath();
    }

    public String getErrorMessage() {
        return exception.getErrorMessage();
    }

    public String getTimeStamp() {
        return exception.getTimeStamp();
    }

    public String getTrace() {
        return exception.getTrace();
    }
}
