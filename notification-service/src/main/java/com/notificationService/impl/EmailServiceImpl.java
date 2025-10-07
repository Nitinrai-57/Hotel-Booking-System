package com.notificationService.impl;

import com.notificationService.dto.UserRegisterEvent;
import com.notificationService.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    MailSender mailSender;
    @Override
    public void sendRegistedMail(UserRegisterEvent userRegisterEvent) {
        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(userRegisterEvent.getEmail());
        message.setSubject("Successfully registered!!");

        message.setText("Hi " + userRegisterEvent.getName() + ",\n\nThanks for registering with us!\n\nBest regards,\nTeam Innovative");
        mailSender.send(message);
    }
}
