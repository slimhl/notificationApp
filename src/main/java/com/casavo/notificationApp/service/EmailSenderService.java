package com.casavo.notificationApp.service;

import com.casavo.notificationApp.entity.Notification;
import com.casavo.notificationApp.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EmailSenderService {
    private NotificationRepository notificationRepository;

    public void buildAndSendNotification(final Notification notification){
        // here the code to send email notification with an email sender provider
        notification.setSentDate(LocalDateTime.now());
        notificationRepository.save(notification);
    }
}
