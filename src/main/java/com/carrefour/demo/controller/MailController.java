package com.carrefour.demo.controller;

import com.carrefour.demo.model.Mail;
import com.carrefour.demo.service.MailService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.InternetAddress;
import java.util.Date;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService){
        this.mailService = mailService;
    }

    @PostMapping(value="/stubService/send")
    public void sendMail(@RequestBody Mail mail){
        try{
            mailService.sendMail(mail);
            System.out.println("Votre mail à bien été envoyé");
        }
        catch (Exception e){
            System.err.println("Erreur survenue lors de l'envoie du message ");
        }

    }
}
