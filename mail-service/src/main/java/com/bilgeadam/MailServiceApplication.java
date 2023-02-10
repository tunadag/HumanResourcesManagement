package com.bilgeadam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MailServiceApplication {

/*    final JavaMailSender javaMailSender;

    public MailServiceApplication(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(MailServiceApplication.class, args);
    }

/*
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("tunadag@gmail.com");
        mailMessage.setTo("tuna_dag@hotmail.com");
        mailMessage.setSubject("Aktivasyon kodunuz: ");
        mailMessage.setText("Kolay gelsin arkadaşlar!");
        javaMailSender.send(mailMessage);
    }
 */
}