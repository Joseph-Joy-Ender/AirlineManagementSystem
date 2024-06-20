package com.example.airlineproject.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    public static final String NEW_PASSENGER_ACCOUNT_VERIFICATION = "New passenger account verification";
    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;
    private String host;
    @Autowired
    private ResourceLoader resourceLoader;


    @Override
    public void sendSimpleMailMessage(String subject, String to, String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject(subject);
            mailMessage.setFrom(fromEmail);
            mailMessage.setTo(to);
            mailMessage.setText(text);
            emailSender.send(mailMessage);
        }catch (Exception e){
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void sendHtmlTemplateEmail(String subject, String recipient) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(MimeMessage.RecipientType.TO, recipient);
        message.setSubject(subject);

        String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
                "<p>It can contain <strong>HTML</strong> content.</p>";
        message.setContent(htmlContent, "text/html; charset=utf-8");

        emailSender.send(message);
    }

    public void sendEmailFromTemplate(String to, String subject, Map<String, String> placeholders) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        Resource resource = resourceLoader.getResource("classpath:template.html");
        String htmlTemplate = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            htmlTemplate = htmlTemplate.replace("${" + entry.getKey() + "}", entry.getValue());
        }

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlTemplate, true);

        emailSender.send(message);
    }


    @Override
    public void sendMimeMessageWithAttachments(String name, String to, String text) {
        try {
            MimeMessage mailMessage = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");
            helper.setPriority(1);
            helper.setSubject(NEW_PASSENGER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText("Hello from the other side");
            FileSystemResource resource = new FileSystemResource(new File(System.getProperty("users.home") + "/Downloads/"));
            emailSender.send(mailMessage);
        }catch (Exception e){
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private MimeMessage getMimeMessage(){
        return emailSender.createMimeMessage();
    }

    @Override
    public void sendMimeMessageWithEmbeddedImage(String name, String to, String token) {

    }

    @Override
    public void sendMimeMessageWithEmbeddedFiles(String name, String to, String token) {

    }

    @Override
    public void sendHtmlEmail(String name, String to, String token) {
        try {
//            Context context = new Context();
//            context.setVariable("Joy");
            MimeMessage mailMessage = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");
            helper.setPriority(1);
            helper.setSubject(NEW_PASSENGER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText("Hello from the other side");
            emailSender.send(mailMessage);
        }catch (Exception e){
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void sendHtmlEmailWithEmbeddedFiles(String name, String to, String token) {

    }
}
