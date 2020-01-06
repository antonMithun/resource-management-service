package com.ibs.training.fullstack.resourcemangement.view;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseView <T> {

    private T data;
    private String message;

    public ResponseView(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseView(T data) {
        this.data = data;
    }

    public ResponseView(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
