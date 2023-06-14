package com.casavo.notificationApp.service;

import com.casavo.notificationApp.entity.Notification;
import com.casavo.notificationApp.entity.NotificationType;
import com.casavo.notificationApp.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationSenderService {

    private EmailSenderService emailSenderService;
    private SmsSenderService smsSenderService;
    private NotificationRepository notificationRepository;


    public void sendNotifications(){
        // get All not already sent notifications
        // we can send the notifications asynchronously using a queue
        List<Notification> emailNotifications= notificationRepository.findAllByTypeAndSentDateIsNull(NotificationType.EMAIL);
        emailNotifications.forEach(notification -> emailSenderService.buildAndSendNotification(notification));
        List<Notification> smsNotifications= notificationRepository.findAllByTypeAndSentDateIsNull(NotificationType.SMS);
        emailNotifications.forEach(notification -> smsSenderService.buildAndSendNotification(notification));
    }

}
