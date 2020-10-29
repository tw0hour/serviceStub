package com.carrefour.demo.controller;

import com.carrefour.demo.model.Mail;
import com.carrefour.demo.service.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService){
        this.mailService = mailService;
    }

    @PostMapping(value="/stubService/send")
    public ResponseEntity sendMail(@RequestBody Mail mail){
        if(mailService.sendMail(mail)){
            return new ResponseEntity("Votre mail à bien été envoyé", HttpStatus.OK);
        }
        return new ResponseEntity("Erreur survenue lors de l'envoie du message", HttpStatus.BAD_REQUEST);
    }
}
