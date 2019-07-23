package com.products.products.exceptionhandling;

public class ApiError {
    private int status;
    private String message;
    private String devMessage;

    public ApiError(int status, String message, String devMessage) {
        this.status = status;
        this.message = message;
        this.devMessage = devMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }
}
