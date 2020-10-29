package com.carrefour.demo.model;

import java.util.List;

public class Mail {

    private List<String> recipients;
    private String subject;
    private String body;

    public Mail(List<String> recipients, String subject, String body) {
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
    }

    //Getter
    public List<String> getRecipients() { return recipients; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }

    //Setter
    public void setRecipients(List<String> recipients) { this.recipients = recipients; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setBody(String body) { this.body = body; }

    @Override
    public String toString() {
        return "Mail{" +
                "recipients=" + recipients +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
