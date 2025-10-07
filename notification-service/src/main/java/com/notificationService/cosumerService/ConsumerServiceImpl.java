package com.notificationService.cosumerService;

import com.notificationService.constant.CommonConstant;
import com.notificationService.dto.UserRegisterEvent;
import com.notificationService.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ConsumerServiceImpl {

    @Autowired
    EmailService emailService;
    @KafkaListener(topics = CommonConstant.TOPIC_NAME,groupId =CommonConstant.GROUP_NAME )
    public void listenUserNotification(UserRegisterEvent userRegisterEvent)
    {
       System.out.println("Getting user infomation"+userRegisterEvent.getUserId()+" "+userRegisterEvent.getEmail()+" "+userRegisterEvent.getName());
       emailService.sendRegistedMail(userRegisterEvent);
    }

}
