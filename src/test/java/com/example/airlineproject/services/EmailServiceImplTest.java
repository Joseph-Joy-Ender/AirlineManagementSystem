package com.example.airlineproject.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class EmailServiceImplTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendEmail() {
        String to = "udeme5017@gmail.com";
        String subject = "New passenger account verification";
        String body = "Thank you for your passenger account verification";
        emailService.sendSimpleMailMessage(subject, to, body);
        assertThat("udeme5017@gmail.com").isEqualTo(to);
    }

    @Test
    public void testSendEmail2() {
        String to = "nelsonakewe0@gmail.com";
        String subject = "New passenger account verification";
        String body = "Dear Nelson Thank you for registering with us";
        emailService.sendSimpleMailMessage(subject, to, body);
        assertThat("nelsonakewe0@gmail.com").isEqualTo(to);
    }

}