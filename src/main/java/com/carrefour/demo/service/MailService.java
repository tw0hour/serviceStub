package com.carrefour.demo.service;

import com.carrefour.demo.model.Mail;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;
import java.util.Date;

@Component
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public boolean sendMail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getRecipients().toArray(new String[0]));
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());
        message.setSentDate(new Date());
        System.out.println(message);

        try{
            mailSender.send(message);
            System.out.println("Votre mail à bien été envoyé");
            return true;
        }catch(MailException e){

            System.err.println("Erreur survenue lors de l'envoie du message ");
        }
        return false;

    }
}
