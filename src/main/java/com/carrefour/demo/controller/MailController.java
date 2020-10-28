package com.carrefour.demo.controller;

import com.carrefour.demo.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.InternetAddress;
import java.util.Date;

@RestController
public class MailController {

    @Autowired
    public JavaMailSender email;

    @PostMapping(value="/stubService/send")
    public void sendMail(@RequestBody Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mail.getRecipients().toArray(new String[0]));
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());
        message.setSentDate(new Date());
        System.out.println(message);
        this.email.send(message);
    }
}
