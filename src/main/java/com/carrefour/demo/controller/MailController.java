package com.carrefour.demo.controller;

import com.carrefour.demo.model.Mail;
import com.carrefour.demo.service.MailService;
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
    public void sendMail(@RequestBody Mail mail){
        mailService.sendMail(mail);
    }
}
