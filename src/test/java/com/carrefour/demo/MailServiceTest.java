package com.carrefour.demo;

import com.carrefour.demo.model.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.Arrays;
import java.util.List;
import com.carrefour.demo.service.MailService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MailServiceTest {

    private MailService mailService;

    @BeforeEach
    void initJavaMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Test
    void testMailParseException() {
        List<String> recipients = Arrays.asList("ismael.abdallah10@gmail..com");
        Mail mail = new Mail(recipients, "objet", "body");
        Exception exception = assertThrows(MailParseException.class, () -> mailService.sendMail(mail));
        assertEquals("Could not parse mail; nested exception is javax.mail.internet.AddressException: Domain contains dot-dot in string ``ismael.abdallah10@gmail..com''", exception.getMessage());
    }
}
