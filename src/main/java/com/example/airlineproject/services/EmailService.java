package com.example.airlineproject.services;

import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.Map;

public interface EmailService {
    void sendSimpleMailMessage(String name, String to, String token);
    void sendHtmlTemplateEmail(String name, String subject) throws MessagingException;
    void sendEmailFromTemplate(String to, String subject, Map<String, String> placeholders) throws MessagingException, IOException;
    void sendMimeMessageWithAttachments(String name, String to, String token);
    void sendMimeMessageWithEmbeddedImage(String name, String to, String token);
    void sendMimeMessageWithEmbeddedFiles(String name, String to, String token);
    void sendHtmlEmail(String name, String to, String token);
    void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token);
}
