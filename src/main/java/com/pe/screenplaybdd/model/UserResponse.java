package com.pe.screenplaybdd.model;

public class UserResponse {
    private String code;
    private String type;
    private String message;
    public UserResponse(){

    }

    public UserResponse(String code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
