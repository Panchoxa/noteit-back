package com.creatorschool.noteit.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FeedbackMailSender implements FeedbackSender {

    private JavaMailSenderImpl mailSender;

    public FeedbackMailSender(Environment environment) {
        mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("spring.mail.port")));
        mailSender.setUsername(environment.getProperty("spring.mail.username"));
        mailSender.setPassword(environment.getProperty("spring.mail.password"));
    }

    @Override
    public void sendFeedback(String from, String name, String feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("feedback@noteit.com");
        message.setSubject("New feedback from " + name);
        message.setText(feedback);
        message.setFrom(from);

        log.info("Preparing to send the feedback!");
        this.mailSender.send(message);
        log.info("Sent the feedback!");
    }
}
