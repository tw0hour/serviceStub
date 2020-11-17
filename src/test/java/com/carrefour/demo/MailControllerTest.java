package com.carrefour.demo;

import com.carrefour.demo.model.Mail;
import com.carrefour.demo.service.MailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

public class MailControllerTest {

    private MailService mailService;

    @BeforeEach
    void initMailService(MailService mailService){
        this.mailService = mailService;
    }

    @Test
    void sendMailTest(@RequestBody Mail mail){
        mailService.sendMail(mail);
        //return new ResponseEntity<>("Votre mail à bien été envoyé", HttpStatus.OK);
        Assert.isInstanceOf(ResponseEntity<>("Votre mail à bien été envoyé", HttpStatus.OK));
    }
    



}
