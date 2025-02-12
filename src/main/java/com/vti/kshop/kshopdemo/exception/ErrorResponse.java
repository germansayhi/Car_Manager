package com.vti.kshop.kshopdemo.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private String timeStamp;
    private String message;
    private Map<String,String> errors;



    public ErrorResponse(String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
        this.timeStamp = LocalDateTime.now().toString();
    }
}
