package com.yod.taller.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class UserException extends RuntimeException {
    private static final long serialVersionUID = -4291966664488195618L;

    private String message;
    private HttpStatus httpStatus;

    public UserException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
