package models;

public class ExceptionReturnObject {
    private String userMessage;
    private String applicationInfo;
    private String httpStatus;

    public ExceptionReturnObject(String userMessage, String applicationInfo) {
        this.userMessage = userMessage;
        this.applicationInfo = applicationInfo;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(String applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String  httpStatus) {
        this.httpStatus = httpStatus;
    }
}
