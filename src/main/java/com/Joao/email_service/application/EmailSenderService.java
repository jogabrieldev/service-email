package com.Joao.email_service.application;

import com.Joao.email_service.adapters.EmailSenderGateway;
import com.Joao.email_service.core.SenderEmailUseCase;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements SenderEmailUseCase {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(EmailSenderGateway emailGateway ){
        this.emailSenderGateway = emailGateway;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
         this.emailSenderGateway.sendEmail(to , subject , body);
    }
}
