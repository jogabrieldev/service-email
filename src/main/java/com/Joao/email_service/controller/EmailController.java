package com.Joao.email_service.controller;

import com.Joao.email_service.application.EmailSenderService;
import com.Joao.email_service.core.EmailRequest;
import com.Joao.email_service.core.exeptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public  EmailController( EmailSenderService emailService){

        this.emailSenderService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
         try{
             this.emailSenderService.sendEmail(request.to(), request.subject() , request.body());
             return ResponseEntity.ok("Email enviado com sucesso");
         } catch (EmailServiceException ex){
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro while sending email");
         }
    }
}
