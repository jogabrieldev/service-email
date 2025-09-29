package com.Joao.email_service.core.exeptions;

public class EmailServiceException extends RuntimeException {

    public  EmailServiceException(String message){
        super(message);
    }

    public  EmailServiceException(String message , Throwable cause){
        super(message , cause);
    }
}
