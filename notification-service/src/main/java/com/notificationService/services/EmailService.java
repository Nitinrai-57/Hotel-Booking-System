package com.notificationService.services;

import com.notificationService.dto.UserRegisterEvent;

public interface EmailService {
    public void sendRegistedMail(UserRegisterEvent userRegisterEvent);
}
