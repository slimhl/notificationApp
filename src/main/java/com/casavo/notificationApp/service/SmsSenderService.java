package com.casavo.notificationApp.service;

import com.casavo.notificationApp.entity.Notification;
import com.casavo.notificationApp.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SmsSenderService {

    private NotificationRepository notificationRepository;

    public void buildAndSendNotification(final Notification notification){
        //here the code to send an SMS using an sms sender provider
        notification.setSentDate(LocalDateTime.now());
        notificationRepository.save(notification);
    }
}
