package com.restapi.restapi.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceCustomerException extends RuntimeException{

    private HttpStatus httpStatus;

    public ServiceCustomerException(HttpStatus httpStatus,String errorMessage){
        super(errorMessage);
        this.httpStatus = httpStatus;
    }
}
