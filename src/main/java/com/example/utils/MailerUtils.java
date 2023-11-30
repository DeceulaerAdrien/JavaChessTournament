package com.example.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailerUtils {
    @Value("${spring.mail.username}")
    private String appEmailAddress;
    private final JavaMailSender javaMailSender;

    public MailerUtils(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendPasswordByEmail(String mailAddress, String title, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(appEmailAddress);
        mailMessage.setTo(mailAddress);
        mailMessage.setSubject(title);
        mailMessage.setText(message);

        this.javaMailSender.send(mailMessage);
    }
}

