package com.casavo.notificationApp.service;

import com.casavo.notificationApp.dto.ClientDTO;
import com.casavo.notificationApp.entity.Client;
import com.casavo.notificationApp.entity.Notification;
import com.casavo.notificationApp.entity.NotificationType;
import com.casavo.notificationApp.entity.RealEstate;
import com.casavo.notificationApp.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService { ;
    private ClientService clientService;
    private NotificationRepository notificationRepository;

    public List<Notification> generateNotifications(final RealEstate realEstate){
        List<Notification> notifications= new LinkedList<>();
        List<Client> eligibleClients= clientService.getEligibleClients(realEstate);
        if(CollectionUtils.isEmpty(eligibleClients)) return Collections.emptyList();
        eligibleClients.forEach(client->buildAndSaveNotification(realEstate,client,notifications));
        return  notifications;
    }

    private void buildAndSaveNotification(RealEstate realEstate,Client client, List<Notification> notifications) {
        Notification emailNotification= Notification.builder().clientId(client.getId()).type(NotificationType.EMAIL)
                .message("Email message").object("Email object").realEstateId(realEstate.getId()).build();
        Notification smsNotification= Notification.builder().clientId(client.getId()).type(NotificationType.SMS)
                .message("SMS message").realEstateId(realEstate.getId()).build();
        notifications.add(notificationRepository.save(emailNotification));
        notifications.add(notificationRepository.save(smsNotification));
    }
}
