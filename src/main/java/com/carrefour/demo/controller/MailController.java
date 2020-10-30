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
    public ResponseEntity<String> sendMail(@RequestBody Mail mail){
        switch(mailService.sendMail(mail)){
            case 1:
                return new ResponseEntity<>("Votre mail à bien été envoyé", HttpStatus.OK);
            case 3 :
                return new ResponseEntity("Parse erreur", HttpStatus.BAD_REQUEST);
            case 4:
                return new ResponseEntity("Erreur survenue lors de l'envoie du message", HttpStatus.valueOf(500));
            case 5:
                return new ResponseEntity("Erreur interne lié à l'authentification", HttpStatus.valueOf(500));
        }
        return new ResponseEntity<>("Votre mail à bien été envoyé", HttpStatus.OK);
    }
}
