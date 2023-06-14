package com.casavo.notificationApp;

import com.casavo.notificationApp.entity.*;
import com.casavo.notificationApp.repository.ClientRepository;
import com.casavo.notificationApp.repository.PreferenceRepository;
import com.casavo.notificationApp.repository.RealEstateRepository;
import com.casavo.notificationApp.service.NotificationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
public class NotificationServiceTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private NotificationService notificationService;

    @Test
    public  void testGenerateNotificationForSpecificRealEstate(){
        RealEstate realEstate= RealEstate.builder().id(1L).price(BigDecimal.valueOf(120000))
                .area(120).type(Type.APARTMENT).city("PARIS").builtDate(LocalDate.of(1993,8,13))
                .numberOfRooms(3).build();
        Client client1 = clientRepository.save(Client.builder().id(1L).email("client1@yopmail.com").firstName("client1")
                .phoneNumber("9999999").lastName("client1").build());
        Client client2 =clientRepository.save( Client.builder().id(2L).email("client2@yopmail.com").firstName("client2")
                .phoneNumber("88888888").lastName("client2").build());
        Client client3 =clientRepository.save( Client.builder().id(3L).email("client3@yopmail.com").firstName("client3")
                .phoneNumber("777777").lastName("client3").build());
        Preference preferenceForClient1=preferenceRepository.save(Preference.builder().clientId(client1.getId()).city("PARIS").area(130)
                .minimumPrice(BigDecimal.valueOf(120000)).maximumPrice(BigDecimal.valueOf(150000)).
                builtDate(LocalDate.of(1990,8,13)).numberOfRooms(3).build());

        //here the preferences of client 2 doesn't macth the real state so this client won't be notified
        Preference preferenceForClient2=preferenceRepository.save(Preference.builder().clientId(client2.getId()).city("PARIS").area(150)
                .minimumPrice(BigDecimal.valueOf(130000)).maximumPrice(BigDecimal.valueOf(150000)).
                builtDate(LocalDate.of(2000,8,13)).numberOfRooms(3).build());

        Preference preferenceForClient3=preferenceRepository.save(Preference.builder().clientId(client3.getId()).city("PARIS").area(120)
                .minimumPrice(BigDecimal.valueOf(110000)).maximumPrice(BigDecimal.valueOf(150000)).
                builtDate(LocalDate.of(1990,8,13)).numberOfRooms(3).build());
        List<Notification> generatedNotifications=notificationService.generateNotifications(realEstate);

        //assert that only client 1 and client 3 will be notified for the given real estate
        //each client will have a sms and email assuming that all the information exists
        //it will be 4 notifications in global
        Assertions.assertEquals(4,generatedNotifications.size());
        Set<Long> notifiedClientIds= generatedNotifications.stream().map(Notification::getClientId).collect(Collectors.toSet());
        Assertions.assertFalse(notifiedClientIds.contains(client2.getId()));
        Assertions.assertTrue(notifiedClientIds.contains(client1.getId()));
        Assertions.assertTrue(notifiedClientIds.contains(client3.getId()));
    }
}
