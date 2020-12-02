package com.carrefour.demo.service;

import com.carrefour.demo.model.Mail;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public int sendMail(Mail mail) {
        if(mail.getRecipients() == null || mail.getBody() == null || mail.getSubject() == null || !isValidMails(mail.getRecipients())){
            return 3;
        }

        SimpleMailMessage message = createMimeMessage(mail);
        try{
            mailSender.send(message);
            return 1;
        }catch(MailPreparationException e){
            return 2;
        }
        catch (MailParseException e){
            return 3;
        }
        catch(MailSendException e){
            return 4;
        }
        catch(MailAuthenticationException e){
            return 5;
        }
    }

    private boolean isValidMails(List<String> mails){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        for(String mail:mails){
            if(!Pattern.matches(regex,mail)){
                return false;
            }
        }
        return true;
    }

    public static SimpleMailMessage createMimeMessage(Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getRecipients().toArray(new String[0]));
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());
        message.setSentDate(new Date());
        return message;
    }
}
