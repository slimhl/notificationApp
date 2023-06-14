package com.casavo.notificationApp.repository;

import com.casavo.notificationApp.entity.Notification;
import com.casavo.notificationApp.entity.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findAllByTypeAndSentDateIsNull(NotificationType notificationType);
}
