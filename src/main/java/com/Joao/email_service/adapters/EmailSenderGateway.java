package com.Joao.email_service.adapters;

public interface EmailSenderGateway {

    void sendEmail(String to , String subject , String body);
}
