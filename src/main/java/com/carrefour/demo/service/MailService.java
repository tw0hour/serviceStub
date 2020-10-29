package com.carrefour.demo.service;


import com.carrefour.demo.model.Mail;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Date;

public class MailService {

    public static void sendMail(Mail mail, JavaMailSender mailSender) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getRecipients().toArray(new String[0]));
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());
        message.setSentDate(new Date());
        System.out.println(message);

        try{
            mailSender.send(message);
        }catch(MailException e){
            throw new Exception(e);
        }

    }
}
