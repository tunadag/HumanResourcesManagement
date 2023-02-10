package com.bilgeadam.service;

import com.bilgeadam.rabbitmq.model.SendEmailPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender javaMailSender;

    public void sendMail(SendEmailPassword sendEmailPassword){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("tunadag@gmail.com");
        mailMessage.setTo(sendEmailPassword.getEmail());
        mailMessage.setSubject("Uygulama şifreniz: ");
        mailMessage.setText(sendEmailPassword.getPassword());
        javaMailSender.send(mailMessage);
    }
}
