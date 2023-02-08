package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class EmployeeMicroserviceException extends  RuntimeException{
    private final ErrorType errorType;

    public EmployeeMicroserviceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public EmployeeMicroserviceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
