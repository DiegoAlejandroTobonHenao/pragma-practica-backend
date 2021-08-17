package com.photoservice.photo.exception;

import org.springframework.http.HttpStatus;

public class PhotoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;

    public PhotoException(HttpStatus httpStatus, String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }
}
