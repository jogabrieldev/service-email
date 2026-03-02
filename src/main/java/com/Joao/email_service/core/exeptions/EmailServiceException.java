package com.Joao.email_service.core.exeptions;

public class EmailServiceException extends RuntimeException {

    public  EmailServiceException(String message){
        super(message);
    }
}
