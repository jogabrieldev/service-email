package com.Joao.email_service.infrastructure.aws;

import com.Joao.email_service.adapters.EmailSenderGateway;
import com.Joao.email_service.core.exeptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final JavaMailSender mailSender;

    @Autowired
    public SesEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("joaog4030@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new EmailServiceException("Falha ao enviar e-mail: " + ex.getMessage());
        }
    }
}
