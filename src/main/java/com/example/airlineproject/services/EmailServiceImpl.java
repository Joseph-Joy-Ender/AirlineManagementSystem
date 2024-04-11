package com.example.airlineproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    public static final String NEW_PASSENGER_ACCOUNT_VERIFICATION = "New passenger account verification";
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;
    private String host;

    @Override
    public void sendSimpleMailMessage(String name, String to, String token) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject(NEW_PASSENGER_ACCOUNT_VERIFICATION);
            mailMessage.setFrom(fromEmail);
            mailMessage.setTo(to);
            mailMessage.setText("Hey this is working!!");
            emailSender.send(mailMessage);
        }catch (Exception e){
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void sendMimeMessageWithAttachments(String name, String to, String token) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedImage(String name, String to, String token) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedFiles(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmail(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token) {

    }
}
