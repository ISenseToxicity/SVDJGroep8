package models;

public class Exception {
    private Integer status;
    private String path;
    private String errorMessage;
    private String timeStamp;
    private String trace;

    public Exception(int status, String path, String errorMessage, String timeStamp, String trace){
        this.status = status;
        this.path = path;
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
        this.trace = trace;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getTrace() {
        return trace;
    }
}
